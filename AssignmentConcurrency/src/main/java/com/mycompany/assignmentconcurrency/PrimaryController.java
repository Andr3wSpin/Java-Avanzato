package com.mycompany.assignmentconcurrency;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.Difficulty;
import model.Partita;

public class PrimaryController {

    @FXML
    private TextField setNome_field;
    @FXML
    private Button btnGioca;
    @FXML
    private RadioButton difSelezionata_facile;
    @FXML
    private RadioButton difSelezionata_medio;
    @FXML
    private RadioButton difSelezionata_difficile;
    @FXML
    private ToggleGroup selezionaDifficolta;
    @FXML
    private VBox erroroMSG;
    @FXML
    private Text errorMSG;
    private Difficulty d;
    
    
    @FXML
    private void creaPartita(ActionEvent event) {
        
        
        
         
             selezionaDifficolta.selectedToggleProperty().addListener((observable,oldValue,newValue) -> {
                 System.out.println("valore " + newValue);
            if(newValue==null) {
              //se caso mai l utente deseleziona il radio di default non lo puo fare
              errorMSG.setVisible(true);
              
        }else {
                
              Toggle selectedTG = selezionaDifficolta.getSelectedToggle(); // controllare il null
        
              RadioButton selected = (RadioButton) selectedTG;
        
               // controllare il default
        
        switch(selected.getText()){
            case "FACILE" : d = Difficulty.FACILE;
            break;
             case"MEDIO" : d =Difficulty.MEDIO;
            break;
             case "DIFFICILE" : d =Difficulty.DIFFICILE ;
            break;
        }
           errorMSG.setVisible(false);
            }
       
          });
        
             if (selezionaDifficolta.getSelectedToggle() == null) {
               errorMSG.setVisible(true);
         }
          
        Partita p;
        //da implemnatre controllo sul nome e sulla difficolta selezionata obbligatori
        // if( chekedInfoGame()){}
        //se le opzioni sono valide crea la partita altrimenti allert di errore 
        
        try{
           p = new Partita(setNome_field.getText(),d); 
            System.out.println(d.toString());
        }catch(NullPointerException ex){
           ex.getMessage();
        }
      
    }
    
    
     //da implemnatre controllo sul nome e sulla difficolta selezionata obbligatori
  
    
    
    
   

  
}   
