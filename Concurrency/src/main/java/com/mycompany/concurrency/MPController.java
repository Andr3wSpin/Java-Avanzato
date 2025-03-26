package com.mycompany.concurrency;

import java.awt.Rectangle;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
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
       
       switch(difficoltaSelezionata) {
           
        case "FACILE": 
            //new Partita();
            break;
        case "MEDIO":
            //new Partita();
            break;    
        case "DIFFICILE":
            //new Partita();
            break;
        default:
            System.out.println("diff: " + difficoltaSelezionata);
            break;
       }
    }

 public void  iniziallizzaStack(){
 
 
 }

   

    @FXML
    private void btnGiocaHover(MouseEvent event) {
   
        TranslateTransition textSlide = new TranslateTransition(Duration.millis(300),text_tastoPLay);
        textSlide.setFromX(0);
        textSlide.setToX(180);
        textSlide.play();
        
        FadeTransition  textOpacity;
        textOpacity = new FadeTransition(Duration.millis(200),text_tastoPLay);
                textOpacity.setFromValue(1.0);
                textOpacity.setToValue(0.0);
                textOpacity.play();
    
        TranslateTransition imageSlide = new TranslateTransition(Duration.millis(300),Icona_play);
        imageSlide.setFromX(0);
        imageSlide.setToX(45);
        imageSlide.play();
    }

    @FXML
    private void btnGiocaHoverOut(MouseEvent event) {
    
        TranslateTransition textSlide = new TranslateTransition(Duration.millis(300),text_tastoPLay);
        textSlide.setFromX(180);
        textSlide.setToX(0);
        textSlide.play();
    
        TranslateTransition imageSlide = new TranslateTransition(Duration.millis(300),Icona_play);
        imageSlide.setFromX(45);
        imageSlide.setToX(0);
        imageSlide.play();
    
       FadeTransition  textOpacity;
        textOpacity = new FadeTransition(Duration.millis(200),text_tastoPLay);
                textOpacity.setFromValue(0.0);
                textOpacity.setToValue(1.0);
                 textOpacity.play();
    }

  
 
}
