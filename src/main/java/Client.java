import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class Client {

    private Socket socket;
    private final String SERVER_ADDR = "localhost";
    private final int SERVER_PORT = 8002;
    private DataInputStream in;
    private DataOutputStream out;
    private BufferedReader reader;

    public static void main(String[] args) throws IOException {
        Client client = new Client();
        client.openConnection();
    }

    public void openConnection() throws IOException {
        socket = new Socket(SERVER_ADDR,SERVER_PORT);
        System.out.println("Connect to " + SERVER_ADDR + ":" + SERVER_PORT );
        System.out.println("Connected!");
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        reader = new BufferedReader(new InputStreamReader(System.in));

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        String strIn = in.readUTF();
                        System.out.println("Server say:" + strIn);
                    }
                } catch (SocketException e) {
                    System.out.println("Socket closed!");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        while(true){

            String strOut = reader.readLine();
            out.writeUTF(strOut);
            System.out.println("Client say: " + strOut);
            if (strOut.equals("end")) {
                closeConnection();
                System.out.println("Client disconnected!");
                break;
            }
        }
    }

    public void closeConnection() throws IOException {

        reader.close();
        in.close();
        out.close();
        socket.close();
    }
}



