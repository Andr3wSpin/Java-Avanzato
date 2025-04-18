package mychat.mychatfx.controller;

import java.io.Serializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import mychat.mychatfx.network.NetworkConnection;

public class MenuChatController {

    @FXML
    private TextArea textArea;
    @FXML
    private TextField msgTXF;
    @FXML
    private Button btnSend;

    
    NetworkConnection user;
    
    public void setUser(NetworkConnection user){
        this.user=user;
    }
    
    public void setMessage(Serializable msg){
        showMessage("received: "+msg.toString());
    }
    
    private void showMessage(String msg){
        textArea.appendText(msg+"\n");
    }
    
    
@FXML
private void sendMsg(KeyEvent event) {
    if (event.getCode() == KeyCode.ENTER) {
        String msg = msgTXF.getText().trim();
        if(!msg.isEmpty()){
            user.sendMsg(msg);
            showMessage("sent: "+msg);
            msgTXF.clear();
        }
        else
        {
            return;
        }
    }
}
    @FXML
    private void sendMSGBTN(ActionEvent event) {
                String msg = msgTXF.getText().trim();
        if(!msg.isEmpty()){
            user.sendMsg(msg);
            showMessage("sent: "+msg);
            msgTXF.clear();
        }
        else
        {
            return;
        }
    }
    
    
    
    
    
    
    
}
