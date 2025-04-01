package com.mycompany.concurrency;

import com.mycompany.concurrency.model.Domanda;
import com.mycompany.concurrency.model.Partita;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MGController {

    @FXML
    private Label LBLTempo;

    @FXML
    private Button BTNFatto;

    @FXML
    private Label LBLRestanti;

    @FXML
    private Label LBLDomanda;

    @FXML
    private TextField TXFRisposta;
    
    private Partita partita;
    private List<Domanda> domande;
    private int indiceDomanda = 0;
    private int tempo;
    private Timeline timeline;
    @FXML
    private Circle timerGrafico;
    
    private final double circ = 2*Math.PI*68;    
    @FXML
    private Rectangle animazioneOnda;
    private  DropShadow shadow;
    
    
    
    
    public void setPartita(Partita partita) {
        
        this.partita = partita;
        
        domande = partita.getDomande();
        
        //collego il bottone all suo rettangolo per l animazione
        animazioneOnda.translateYProperty().bind(BTNFatto.translateYProperty());
          shadow = new DropShadow();
         shadow.setColor(Color.rgb(0, 0, 0, 0.3));
        setDomanda();
    }
   
    private void setDomanda(){
     
        if(indiceDomanda < domande.size()) {
            
          LBLDomanda.setText(domande.get(indiceDomanda).toString() + " = ?");
          
          LBLRestanti.setText((indiceDomanda + 1) + "/" + domande.size());
          
          TXFRisposta.setText("");
          timerGrafico.getStrokeDashArray().addAll(circ);
          timerGrafico.setStrokeDashOffset(0);
          if(timeline != null) timeline.stop();
          
          tempo = partita.getTempo();
          
          avviaTimer();
          
          indiceDomanda++;
        } 
        else {
         
            timeline.stop();
            
            LBLDomanda.setText("Finish!");
            
            LBLRestanti.setVisible(false);
            
            cambiaSchermata();
        }
    }
   
    private void avviaTimer() {
        
        int secondi = partita.getTempo();
        
        timeline = new Timeline(new KeyFrame(
        Duration.seconds(1), e -> {
            double offsetAttuale = timerGrafico.getStrokeDashOffset();
            aggiornaTimer();
            timerGrafico.setStrokeDashOffset(offsetAttuale+(circ / (secondi)));
              
                }));
        
        timeline.setCycleCount(secondi+1);
        
        timeline.setOnFinished(e -> { avanza(); });
        
        timeline.play();
    }
    
    private void aggiornaTimer() {
        
        if (tempo >= 0) {
            
            LBLTempo.setText(tempo + ""); 
            
            tempo--;
        } else {
            TXFRisposta.setText(""); 
            
            setDomanda(); 
        }
    }
    
    @FXML
    private void avanza() {
        
        animazioneClick();
        String risposta = TXFRisposta.getText();
        domande.get(indiceDomanda - 1).setRisposta(risposta);
        
        setDomanda();
    }
    
    private void cambiaSchermata() {
     
        try {  
            FXMLLoader loader = new FXMLLoader(MRController.class.getResource("menuRisultato.fxml"));
            Scene scena = new Scene(loader.load(), 640, 480);
        
            MRController mrController = loader.getController();
            mrController.setPartita(partita);
          
            Stage stage = (Stage) BTNFatto.getScene().getWindow();
        
            stage.setScene(scena);
            
            stage.show();
        } catch(IOException e) {
            
            System.out.println("Erroer durante la generazione della nuova schermata!");
        }
   
     }
    
    public void animazioneClick(){
    
        
      
       
         ScaleTransition allarga = new ScaleTransition(Duration.seconds(0.3),animazioneOnda);
        allarga.setToX(1.7);
        allarga.setToY(3.5);
        allarga.play();
        FadeTransition scompari = new FadeTransition(Duration.seconds(0.2),animazioneOnda);
        scompari.setToValue(0);
        scompari.play();
        
               
        
        allarga.setOnFinished( e-> {
        
            animazioneOnda.setScaleX(1);
            animazioneOnda.setScaleY(1);
            animazioneOnda.setOpacity(0.7);
            
        
        });
        
               
    }

    @FXML
    private void onMouseExitedAnimation(MouseEvent event) {
         TranslateTransition click = new TranslateTransition(Duration.seconds(0.2),BTNFatto);
         click.setToY(5);
         click.play();
         BTNFatto.setEffect(null);
         

   
    }

    @FXML
    private void onMousePressedAnimation(MouseEvent event) {
        TranslateTransition click = new TranslateTransition(Duration.seconds(0.2),BTNFatto);
        click.setToY(5);
        click.setAutoReverse(true);
        click.setCycleCount(2);
        click.play();
        
           Timeline timeline = new Timeline( new KeyFrame(Duration.ZERO,  t->{
        
        shadow.setOffsetX(0);
        shadow.setOffsetY(10);
        shadow.setRadius(20);
        BTNFatto.setEffect(shadow);
        }),
      
                    new KeyFrame(Duration.seconds(0.1),  t->{
        
        shadow.setOffsetX(0);
        shadow.setOffsetY(8);
        shadow.setRadius(17);
        BTNFatto.setEffect(shadow);
       
       }),
                    new KeyFrame(Duration.seconds(0.1),  t->{
        
        shadow.setOffsetX(0);
        shadow.setOffsetY(6);
        shadow.setRadius(13);
        BTNFatto.setEffect(shadow);
       
       }),
       new KeyFrame(Duration.seconds(0.1),  t->{
        
        shadow.setOffsetX(0);
        shadow.setOffsetY(4);
        shadow.setRadius(10);
        BTNFatto.setEffect(shadow);
       
       }),
      
       new KeyFrame(Duration.seconds(0.2),  t->{
        
        shadow.setOffsetX(0);
        shadow.setOffsetY(3);
        shadow.setRadius(7);
        BTNFatto.setEffect(shadow);
       
       })
      
      );
      
         timeline.setCycleCount(2);
         timeline.setAutoReverse(true);
        timeline.play();
       
   
        
    }

    @FXML
    private void onMouseEntredAnimation(MouseEvent event) {
        
      Timeline timeline = new Timeline( new KeyFrame(Duration.ZERO,  t->{
        
        shadow.setOffsetX(0);
        shadow.setOffsetY(0);
        shadow.setRadius(0);
        BTNFatto.setEffect(shadow);
        }),
       new KeyFrame(Duration.seconds(0.1),  t->{
        
        shadow.setOffsetX(0);
        shadow.setOffsetY(4);
        shadow.setRadius(10);
        BTNFatto.setEffect(shadow);
       
       }),
       new KeyFrame(Duration.seconds(0.13),  t->{
        
        shadow.setOffsetX(0);
        shadow.setOffsetY(6);
        shadow.setRadius(10);
        BTNFatto.setEffect(shadow);
       
       }),
       new KeyFrame(Duration.seconds(0.16),  t->{
        
        shadow.setOffsetX(0);
        shadow.setOffsetY(8);
        shadow.setRadius(10);
        BTNFatto.setEffect(shadow);
       
       }),
       new KeyFrame(Duration.seconds(0.2),  t->{
        
        shadow.setOffsetX(0);
        shadow.setOffsetY(10);
        shadow.setRadius(20);
        BTNFatto.setEffect(shadow);
       
       })
      
      );
      
      
        timeline.play();
       
        TranslateTransition hover= new TranslateTransition(Duration.seconds(0.2),BTNFatto);
          hover.setToY(-5);
          hover.play();
    }


   
    
 
    
}
    