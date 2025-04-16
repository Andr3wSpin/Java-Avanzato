package mychat.mychatfx.controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MenuPrincipaleController {

    @FXML
    private Button yesBtn;
    @FXML
    private Button noBtn;

    private void switchToSecondary() throws IOException {
        //App.setRoot("secondary");
    }

    @FXML
    private void startServer(ActionEvent event) {
    }

    @FXML
    private void startClient(ActionEvent event) {
    }
}
