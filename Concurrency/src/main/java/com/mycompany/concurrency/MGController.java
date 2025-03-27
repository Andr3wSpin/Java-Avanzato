package com.mycompany.concurrency;

import com.mycompany.concurrency.model.Domanda;
import com.mycompany.concurrency.model.Partita;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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

    
    @Override
     public void initialize(URL location, ResourceBundle resources) {
        
       BTNFatto.setOnAction(e -> setDomanda());
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
          
          avviaTimer();
          
          indiceDomanda++;
        } 
    }
   
    private void avviaTimer() {
        
        
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
    