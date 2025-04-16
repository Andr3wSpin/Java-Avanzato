package mychat.mychatfx.controller;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;

public class MenuServerController implements Initializable {

    @FXML
    private Label ipLbl;
    @FXML
    private TextField ipTxf;
    @FXML
    private Label portaLbl;
    @FXML
    private TextField portaTxf;
    @FXML
    private Label label;
    @FXML
    private Button serverBtn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        serverBtn.disableProperty().bind(
                Bindings.and(portaTxf.textProperty().isEmpty(), portaTxf.textProperty().isEmpty())
        );

        serverBtn.visibleProperty().bind(
                Bindings.and(portaTxf.textProperty().isNotEmpty(), portaTxf.textProperty().isNotEmpty())
        );
    }

    @FXML
    private void avviaServer(ActionEvent event) {
    }
}