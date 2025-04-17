package mychat.mychatfx.network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.function.Consumer;

public abstract class NetworkConnection {

    private String IP;
    private int port;
    private ConnectionThread connectionThread;
    private Consumer<Serializable> receiveCallBack;

    public NetworkConnection(String IP, int port, Consumer<Serializable> receiveCallBack) {

        this.IP = IP;
        this.port = port;
        this.receiveCallBack = receiveCallBack;
        this.connectionThread = new ConnectionThread();
    }

    public abstract boolean isServer();

    public void sendMsg(Serializable msg) {

        //accedere ad output stream per scrivere il messaggio
        try {

            connectionThread.oos.writeObject(msg);
        } catch (IOException e) {

            System.err.println(e.getMessage());
        }
    }

    public void onReceive(Serializable msg) {

        System.out.println("Ricevuto: " + msg);
    }

    public void connect() {

        connectionThread.start();
    }

    public void disconnect() {

        try {

            connectionThread.socket.close();
        } catch (IOException e) {

            System.err.println(e.getMessage());
        }
    }

    private class ConnectionThread extends Thread {

        ObjectOutputStream oos;
        Socket socket;

        @Override
        public void run() {

            //va sempre gestito prima l'output stream e poi l'input stream
            try(Socket socket = isServer() ? new ServerSocket(port).accept() : new Socket(IP, port);
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream())
                ) {

                this.oos = oos;
                this.socket = socket;

                while(true) {

                    Serializable msg = (Serializable) ois.readObject();

                    receiveCallBack.accept(msg);

                    //onReceive(msg);
                }


            } catch (IOException e) {


            } catch (ClassNotFoundException e) {

                System.err.println(e.getMessage());
            }
        }
    }
}
