package mychat.mychatfx.controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MenuPrincipaleController {

    @FXML
    private Label label;
    @FXML
    private Button serverBtn;
    @FXML
    private Label ipLbl;
    @FXML
    private TextField ipTxf;
    @FXML
    private Label portaLbl;
    @FXML
    private TextField portaTxf;

    private void switchToSecondary() throws IOException {
        //App.setRoot("secondary");
    }

}
