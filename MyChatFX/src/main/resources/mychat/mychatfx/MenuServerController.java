/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mychat.mychatfx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author andre
 */
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void avviaServer(ActionEvent event) {
    }
    
}
