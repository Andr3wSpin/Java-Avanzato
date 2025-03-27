
package com.mycompany.concurrency;

import com.mycompany.concurrency.export.FileManager;
import com.mycompany.concurrency.model.Domanda;
import com.mycompany.concurrency.model.Partita;
import java.io.File;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


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
        
        Stage stage = (Stage) btnEsporta.getScene().getWindow();
        
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showSaveDialog(stage);

        if(file == null) return;
        
        FileManager.esportaFile(file, partita.getDomande());
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

        etichetta.setText("Gentile " + partita.getNomeGiocatore() + ", grazie per aver giocato al quiz.\n"
                + " Salva il file con l'esito e condivido con i tuoi amici.");
    }
}
