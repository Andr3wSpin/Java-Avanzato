package classi;

import java.io.Serializable;
import java.util.function.Consumer;

public class Client extends NetworkConnection{

    public Client(String IP, int port, Consumer<Serializable> receiverCallBack) {

        super(IP, port, receiverCallBack);
    }

    @Override
    public boolean isServer() { return false; }
}
