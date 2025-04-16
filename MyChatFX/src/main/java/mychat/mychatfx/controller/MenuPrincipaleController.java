package mychat.mychatfx.controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;

public class MenuPrincipaleController {

    @FXML
    private Label label;
    @FXML
    private Label ipLbl;
    @FXML
    private Label portaLbl;
    @FXML
    private TextField ipTf;
    @FXML
    private TextField portaTf;
    @FXML
    private RadioButton serverBtn;
    @FXML
    private RadioButton clientBtn;

    private void switchToSecondary() throws IOException {
        //App.setRoot("secondary");
    }

}
