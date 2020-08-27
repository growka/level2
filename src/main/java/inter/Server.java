package inter;

import handler.ClientHandler;
import service.AuthServiceImpl;

public interface Server {

    int PORT = 8002;

    boolean isNickBusy(String Nick);

    void broadcastMsg(String msg);

    void subcribe(ClientHandler client);

    void unsubcribe(ClientHandler client);

    AuthServiceImpl getAuthService();
}
