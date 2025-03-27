package com.mycompany.concurrency;


import java.awt.Rectangle;

import com.mycompany.concurrency.model.Difficolta;
import com.mycompany.concurrency.model.Partita;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.beans.binding.Binding;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

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
    @FXML
    private StackPane StackBtnGioca;
    @FXML
    private ImageView Icona_play;
    @FXML
    private Text text_tastoPLay;
    
    public  Partita p;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        inizializzaRadioButton();
        inizializzaPulsanteGioca();
        
         iniziallizzaStack();
        
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
        
        creaPartita();
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("menuGioco.fxml"));
        Parent root = loader.load(); 
        MGController mgController = loader.getController();
        mgController.setP(p); 
         
        Stage nuovoStage = new Stage();
        nuovoStage.setScene(new Scene(root));
        nuovoStage.show();
      
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
          p =  new Partita(setNome_field.getText(),difficolta);
            break;
        case MEDIO:
            //new Partita();
              p =  new Partita(setNome_field.getText(),difficolta);
            break;    
        case DIFFICILE:
            //new Partita();
              p =  new Partita(setNome_field.getText(),difficolta);
            break;
       }
    }

 public void  iniziallizzaStack(){
 
 
 }

   

    @FXML
    private void btnGiocaHover(MouseEvent event) {
   
        TranslateAnimation(true);
    }

    @FXML
    private void btnGiocaHoverOut(MouseEvent event) {
    
          TranslateAnimation(false);
    }

  public void TranslateAnimation (boolean inOut){
  
   if(inOut){
        
         TranslateTransition textSlide = new TranslateTransition(Duration.millis(300),text_tastoPLay);
        textSlide.setFromX(0);
        textSlide.setToX(100);
        textSlide.play();
        
        TranslateTransition imageSlide = new TranslateTransition(Duration.millis(300),Icona_play);
        imageSlide.setFromX(0);
        imageSlide.setToX(45);
        imageSlide.play();
          FadeTransition  textOpacity;
        textOpacity = new FadeTransition(Duration.millis(300),text_tastoPLay);
                textOpacity.setFromValue(1.0);
                textOpacity.setToValue(0.0);
                 textOpacity.play();
  
  }else{
     
      TranslateTransition textSlide = new TranslateTransition(Duration.millis(300),text_tastoPLay);
        textSlide.setFromX(100);
        textSlide.setToX(0);
        textSlide.play();
    
        TranslateTransition imageSlide = new TranslateTransition(Duration.millis(300),Icona_play);
        imageSlide.setFromX(45);
        imageSlide.setToX(0);
        imageSlide.play();
     FadeTransition  textOpacity;
        textOpacity = new FadeTransition(Duration.millis(300),text_tastoPLay);
                textOpacity.setFromValue(0.0);
                textOpacity.setToValue(1.0);
                 textOpacity.play();
     }          
 
  }
}
