package mychat.mychatfx.controller;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import mychat.mychatfx.App;
import mychat.mychatfx.network.Client;
import mychat.mychatfx.network.NetworkConnection;
import mychat.mychatfx.network.Server;

public class MenuPrincipaleController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private Label ipLbl;
    @FXML
    private Label portLbl;
    @FXML
    private TextField ipTf;
    @FXML
    private TextField portTf;
    @FXML
    private ToggleGroup mode;
    @FXML
    private RadioButton serverBtn;
    @FXML
    private RadioButton clientBtn;
    @FXML
    private Button startBtn;

    private Alert alert;
    private Scene scenaChat;

    private String ip;
    private String port;
    private NetworkConnection user;
    private int p;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        alert = new Alert(Alert.AlertType.ERROR);

        inizializzaRadioButton();
        inizializzaTextField();
        inizializzaLabel();
    }

    private void inizializzaRadioButton() {

        serverBtn.setToggleGroup(mode);
        clientBtn.setToggleGroup(mode);
    }

    private void inizializzaTextField() {

        //campo IP visibile solo se viene scelta l'opzione Client
        ipTf.visibleProperty().bind(clientBtn.selectedProperty());

        //campo IP accetta solo cifre e "."
        ipTf.setTextFormatter(new TextFormatter<>(change -> {

            String newText = change.getControlNewText();

            return newText.matches("[\\d\\.]*") ? change : null;
        }));

        //il campo porta accetta solo cifre
        portTf.setTextFormatter(new TextFormatter<>(change -> {

            String newText = change.getControlNewText();

            return newText.matches("\\d*") ? change : null;
        }));
    }

    private void inizializzaLabel() {

        //etichetta IP visibile solo se viene scelta l'opzione Client
        ipLbl.visibleProperty().bind(clientBtn.selectedProperty());
    }

    private boolean validIP(String ip) {

        if(ip.isEmpty()) return false;

        if(ip.startsWith(".") || ip.endsWith(".")) return false;

        String[] campi = ip.split("\\.");

        if(campi.length != 4) return false;

        return Arrays.stream(campi).mapToInt(Integer::parseInt)
                .noneMatch(o -> o < 0 || o > 255);
    }
    
    private boolean validPort(String port) {

        if(port.isEmpty()) return false;

        try {

            p = Integer.parseInt(port);

            return p >= 0 && p <= 65_535;
        } catch (NumberFormatException e) { return false; }
    }

    private boolean validServerInfo() {

        port = portTf.getText();

        if(!validPort(port)) {

            mostraErrore("Porta non valida!");

            return false;
        }

        return true;
    }

    private boolean validClientInfo() {

        ip = ipTf.getText();

        if(!validIP(ip)) {

            mostraErrore("IP non valido!");;

            return false;
        }

        return validServerInfo();
    }

    private void cambiaSchermata(Stage stage) {

            if(user.isServer()) stage.setTitle("MyChatFXServer");
            else stage.setTitle("MyChatFXClient");

            stage.setScene(scenaChat);
    }

    private MenuChatController getController() {

        try {

            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("MenuChat.fxml"));

            scenaChat = new Scene(fxmlLoader.load());

            return fxmlLoader.getController();

        } catch(IOException e) {

            mostraErrore("Errore durante il cambio schermata!");

            return null;
        }
    }

    private void creaConnessione(MenuChatController controller) {

        if(serverBtn.isSelected()) user = new Server(p, msg -> controller.setMessage(msg));
        else user = new Client(ip, p, msg -> controller.setMessage(msg));

        user.connect();

        controller.setUser(user);
    }

    private void mostraErrore(String msg) {

        alert.setContentText(msg);
        alert.showAndWait();
    }

    @FXML
    private void avviaChat(ActionEvent event) {

        if(!serverBtn.isSelected() && !clientBtn.isSelected()) {

            mostraErrore("Selezionare una tra le due opzioni \"Server\" o \"Client\"!");;

            event.consume();

            return;
        }

        boolean check = serverBtn.isSelected() ? validServerInfo() : validClientInfo();

        if(!check) {

            event.consume();

            return;
        }

        MenuChatController controller = getController();

        if(controller == null) {

            event.consume();

            return;
        }

        creaConnessione(controller);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setOnCloseRequest(e -> user.disconnect());

        cambiaSchermata(stage);
    }
}
