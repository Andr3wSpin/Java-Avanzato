package mychat.mychatfx;

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
    private TextField messageTF;
    @FXML
    private Button sendButton;

    @FXML
    private void sendMessage(KeyEvent event) {
    }

    @FXML
    private void sendMs(ActionEvent event) {
    }
}
