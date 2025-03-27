/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.concurrency;

import com.mycompany.concurrency.model.Domanda;
import com.mycompany.concurrency.model.Partita;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


public class MRController {

    @FXML
    private TableView<Domanda> TBLEsiti;
    
    @FXML
    private TableColumn<Domanda, String> colonnaDomande;
    
    @FXML
    private TableColumn<Domanda, String> colonnaEsiti;
   
    @FXML
    private Button btnEsporta;
 
    @FXML
    private Label etichetta;
    
    private ObservableList<Domanda> esiti;
    private Partita partita;
    
    public void setPartita(Partita partita) {
        
        this.partita = partita;
    
        esiti = FXCollections.observableArrayList(partita.getDomande());
        
        inizializzaTabella();
        inizializzaEtichetta();
    }
   
    @FXML
    private void esportaEsito() {
        
    }

    private void inizializzaTabella() {

       TBLEsiti.setItems(esiti);
       
       colonnaDomande.setCellValueFactory(d -> { return new SimpleStringProperty(d.getValue().toString()); });
       colonnaEsiti.setCellValueFactory(d -> { 
            String str;
    
            if (d.getValue().isCorrect()) 
                str = "Risposta corretta";
            else 
            str = "Risposta errata";
    
            return new SimpleStringProperty(str);
        });
    }

    private void inizializzaEtichetta() {

        etichetta.setText(partita.getNomeGiocatore() + ", esporta l'esito della tua partita \ne condivilo con i tuoi amici.");
    }
}
