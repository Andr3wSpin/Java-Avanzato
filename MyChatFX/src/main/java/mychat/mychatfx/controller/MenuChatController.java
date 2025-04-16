package mychat.mychatfx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class MenuChatController {

    @FXML
    private TextArea textArea;
    @FXML
    private TextField msgTXF;
    @FXML
    private Button btnSend;

    @FXML
    private void sendMSGKey(KeyEvent event) {
    }

    @FXML
    private void sendMSGbtn(ActionEvent event) {
    }
}
