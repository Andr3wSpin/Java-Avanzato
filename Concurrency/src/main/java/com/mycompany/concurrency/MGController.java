package com.mycompany.concurrency;

import com.mycompany.concurrency.model.Domanda;
import com.mycompany.concurrency.model.Partita;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;
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
    public void setPartita(Partita partita) {
        
        this.partita = partita;
        
        domande = partita.getDomande();
        
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
}
    