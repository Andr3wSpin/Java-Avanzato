package mychat.mychatfx.network;

import java.util.Locale;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Server server = new Server(12100, msg -> System.out.println("Ricevuto: " + msg));

        server.connect();

        System.out.println("Server in attesa di connessione...");

        Thread.sleep(2000);

        Client client = new Client("127.0.0.1", 12100, msg -> System.out.println("Ricevuto: " + msg));

        client.connect();

        System.out.println("Client richiede connessione...");

        Thread.sleep(2000);

        client.sendMsg("Ciao Server!");

        Thread.sleep(1000);

        server.onReceive("Ciao Client!");

        Thread.sleep(1000);

        client.sendMsg("Arrivederci.");

        client.disconnect();

        server.disconnect();
    }
}
