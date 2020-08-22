import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.TreeMap;

public class ChatServer {

    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private BufferedReader reader;
    private ServerSocket server;



    public static void main(String[] args) throws IOException {

        ChatServer chatServer = new ChatServer();
        chatServer.startSrv();

    }
        public void startSrv() throws IOException {

            socket = null;

        try {
            server = new ServerSocket(8002);
            System.out.println("Server started at port: " + server.getLocalPort());
            socket = server.accept();
            System.out.println("Client connected!");
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream((socket.getOutputStream()));
            reader = new BufferedReader(new InputStreamReader(System.in));

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (true) {
                            // System.out.println("Поток открыт!");

                                String strOut = null;
                                try {
                                    strOut = reader.readLine();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                try {
                                    out.writeUTF(strOut);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                //System.out.println("Поток закрыт");
                        }
                    }
                }).start();

                while (true) {
                    String strIn = in.readUTF();
                    System.out.println("Client say: " + strIn);
                    if (strIn.equals("end")) {
                       serverDown();
                    }
                }

            } catch(SocketException e){
                e.printStackTrace();
        }
    }

    public void serverDown() throws IOException {
        in.close();
        out.close();
        reader.close();
        socket.close();
        server.close();
        System.out.println("Client disconnected!");
        System.out.println("Server down!");
        System.exit(0);
    }
}

