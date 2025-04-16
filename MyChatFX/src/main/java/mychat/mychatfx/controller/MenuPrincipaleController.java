package mychat.mychatfx.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;

public class MenuPrincipaleController implements Initializable {

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }
}
