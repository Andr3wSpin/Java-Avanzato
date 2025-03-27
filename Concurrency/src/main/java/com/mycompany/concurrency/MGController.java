package com.mycompany.concurrency;

import com.mycompany.concurrency.model.Domanda;
import com.mycompany.concurrency.model.Partita;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.stage.Stage;
import javafx.util.Duration;

public class MGController implements Initializable{

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

    
    @Override
     public void initialize(URL location, ResourceBundle resources){
     
     }
     
    public void setPartita(Partita partita) {
        
        this.partita = partita;
        
        domande = partita.getDomande();
        
        setDomanda();
    }
   
    private void setDomanda(){
     
        if(indiceDomanda < domande.size()) {
            
          LBLDomanda.setText(domande.get(indiceDomanda).toString());
          
          LBLRestanti.setText((indiceDomanda + 1) + "/" + domande.size());
          
          TXFRisposta.setText("");
          
          if(timeline != null) timeline.stop();
          
          tempo = partita.getTempo();
          
          avviaTimer();
          
          indiceDomanda++;
        } 
        else {
         
            LBLDomanda.setText("Finish!");
            
            LBLRestanti.setVisible(false);
            
            cambiaSchermata();
        }
    }
   
    private void avviaTimer() {
        
        int secondi = partita.getTempo();
        
        timeline = new Timeline(new KeyFrame(
        Duration.seconds(1), e -> aggiornaTimer()));
        
        timeline.setCycleCount(partita.getTempo());
        
        timeline.setOnFinished(e -> { TXFRisposta.setText(""); setDomanda(); });
        
        timeline.play();
    }
    
    private void aggiornaTimer() {
        
        if (tempo > 0) {
            
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
        
        if(risposta.isEmpty() || !risposta.matches("[0-9]+"))
            domande.get(indiceDomanda - 1).setRisposta("");
        else
            domande.get(indiceDomanda - 1).setRisposta(risposta);
        
        setDomanda();
    }
    
    private void cambiaSchermata() {
     
        try {
            FXMLLoader loader = new FXMLLoader(MRController.class.getResource("menuRisultato.fxml"));
            Scene scena = new Scene(loader.load());
        
            Stage stage = (Stage) BTNFatto.getScene().getWindow();
        
            stage.setScene(scena);
            
            stage.show();
        } catch(IOException e) {
            
            System.out.println("Erroer durante la generazione della nuova schermata!");
        }
    }
    
    /*
    //@FXML
    public void cambiaDomandaBtn(ActionEvent event) {
        /*
     if(indiceDomanda<10){ 
         //mostra la domanda 
         setDomanda(indiceDomanda);
        
         
         // il listner si potrebbe usare per i controlli di input solo numeri 
        /*
         TXFRisposta.textProperty().addListener((observable, oldValue ,newValue) ->{
            }); */
         /*  
         setRisposta(TXFRisposta.getText());
         indiceDomanda++;
     }
     else{ 
         
       LBLDomanda.setText("Finish!");
       StampaRisposteProva();
     }
       
      if(indiceDomanda>=9 && (LBLDomanda.getText().equals("Finish"))){
      
          //carica schermata risultato
          LBLDomanda.setText("Vedi Risulatato");
          
      }
    
    }
   
    private void changeDomandaWithTimer(){
    
    
    }
    
    
    
    
    private void setRisposta(String ri){
      //aggiunge il riuslato alla lista 
           System.out.println(ri); // solo per debug
           domande.get(indiceDomanda).setRisposta(ri); // aggiungo la risposta 
           TXFRisposta.setText(""); //setto il campo vuoto ogni nuova domanda
          
       
    }
    
    
    private void StampaRisposteProva(){
        //solo per debug 
     System.out.println("Risposte:");
    for (int i = 0; i < domande.size(); i++) {
        System.out.println("Domanda " + i  + ": " + domande.get(i).getRisposta()+"\n");
    
    
    }
    
    } 
*/
}
    