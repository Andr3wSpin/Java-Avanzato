package com.mycompany.concurrency;

import com.mycompany.concurrency.model.Difficolta;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Binding;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class MPController implements Initializable {

    @FXML
    private VBox erroroMSG;
    @FXML
    private TextField setNome_field;
    @FXML
    private Text errorMSG;
    @FXML
    private RadioButton difSelezionata_facile;
    @FXML
    private ToggleGroup selezionaDifficolta;
    @FXML
    private RadioButton difSelezionata_medio;
    @FXML
    private RadioButton difSelezionata_difficile;
    @FXML
    private Button btnGioca;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        inizializzaRadioButton();
        inizializzaPulsanteGioca();
    }
    
    private void inizializzaRadioButton() {
        
        difSelezionata_facile.setUserData("FACILE");
        difSelezionata_medio.setUserData("MEDIO");
        difSelezionata_difficile.setUserData("DIFFICILE");
        
        difSelezionata_facile.setToggleGroup(selezionaDifficolta);
        difSelezionata_medio.setToggleGroup(selezionaDifficolta);
        difSelezionata_difficile.setToggleGroup(selezionaDifficolta);
    }
    
    @FXML
    private void cambiaSchermata(ActionEvent event) throws IOException{
        App.setRoot("menuGioco");
        creaPartita();
    }

    private void inizializzaPulsanteGioca() {
        
        //il pulsante è cliccabile solo se il TF del nome non è vuoto ed è stata selezionata la difficoltà
        btnGioca.disableProperty().bind(
                Bindings.or(setNome_field.textProperty().isEmpty(), 
                        selezionaDifficolta.selectedToggleProperty().isNull()));
        
         //il pulsante è visibile solo se il TF del nome non è vuoto ed è stata selezionata la difficoltà
        btnGioca.visibleProperty().bind(
                Bindings.and(setNome_field.textProperty().isNotEmpty(), 
                        selezionaDifficolta.selectedToggleProperty().isNotNull()));
    }

    private void creaPartita() {

       String difficoltaSelezionata = selezionaDifficolta.getSelectedToggle().getUserData().toString();
       
       Difficolta difficolta = Difficolta.valueOf(difficoltaSelezionata);
       
       switch(difficolta) {
           
        case FACILE: 
            //new Partita();
            break;
        case MEDIO:
            //new Partita();
            break;    
        case DIFFICILE:
            //new Partita();
            break;
       }
    }
}
