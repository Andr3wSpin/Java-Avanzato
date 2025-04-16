package mychat.mychatfx.network;

import java.io.Serializable;
import java.util.function.Consumer;

public class Server extends NetworkConnection {

    public Server(int port, Consumer<Serializable> receiverCallBack) {

        super(null, port, receiverCallBack);
    }

    @Override
    public boolean isServer() { return true; }
}
