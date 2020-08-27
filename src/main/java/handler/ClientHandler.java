package handler;

import inter.Server;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {

    private Server server;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    private String nick;

    public String getNick() {
        return nick;
    }

    public ClientHandler(Server server, Socket socket) {
        try {
            this.server = server;
            this.socket = socket;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());
            this.nick = "";
            new Thread(() -> {
                try {
                    authentication();
                    readMessage();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    closeConnection();
                }
            }).start();
        } catch (IOException e) {
            throw new RuntimeException("Проблемы при создании обработчика клиента");
        }
    }

    private void authentication() throws IOException {
        while (true) {
            String str = in.readUTF();
            if (str.startsWith("/auth")) {
                String [] dataArray = str.split("\\s");
                String nick = server.getAuthService().getNick(dataArray[1], dataArray[2]);
                if (nick != null) {
                    if (!server.isNickBusy(nick)) {
                        sendMsg("/authOk " + nick);
                        this.nick = nick;
                        server.broadcastMsg(this.nick + " зашёл в чат.");
                        server.subcribe(this);
                        return;
                    } else {
                        sendMsg("Учетная запись уже используется!");
                    }
                } else {
                    sendMsg("Неверный логин/пароль");
                }
            }
        }
    }

    public void sendMsg(String msg) {
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void readMessage() throws IOException {
        while (true) {
            String clientStr = in.readUTF();
            System.out.println(nick + ": " + clientStr);
            if (clientStr.equals("/exit")) {
                return;
            }
            server.broadcastMsg(nick + ": " + clientStr);
        }

    }

    public void closeConnection() {
        server.unsubcribe(this);
        server.broadcastMsg(nick + " вышел из чата.");
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

