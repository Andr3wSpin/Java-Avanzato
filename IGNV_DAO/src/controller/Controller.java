package controller;

import model.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.CaricaReportService;
import model.INGEvent;

public class Controller implements Initializable {

    @FXML
    private TableView<INGEvent> eventTable;
    @FXML
    private TableColumn<INGEvent, String> dateColumn;
    @FXML
    private TableColumn<INGEvent, String> magnitudeColumn;
    @FXML
    private TableColumn<INGEvent, String> locationColumn;
    @FXML
    private DatePicker dataInizio;
    @FXML
    private DatePicker dataFine;
    @FXML
    private TextField limiteTxf;
    @FXML
    private Button caricaBtn;
    @FXML
    private TextField serchBar;
    @FXML
    private ContextMenu contextMenu;
    @FXML
    private MenuItem esportaBtn;
    @FXML
    private ProgressBar caricamentoDati;
    @FXML
    private Label percentuale;
    
    private ProgressIndicator pi;
    private ObservableList obList;
    private FilteredList<INGEvent> fList;
    private Alert alert;
    
    private String url;
    private CaricaReportService crs;
    
    private INGEventDAOPostGres ingPostGres  = new INGEventDAOPostGres();
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) { 
            pi = new ProgressIndicator();            
            this.url = "https://webservices.ingv.it/fdsnws/event/1/query?starttime=2020-11-18T00%3A00%3A00&endtime=" +
                    "2020-11-25T23%3A59%3A59&minmag=2&maxmag=10&mindepth=-10&maxdepth=1000&minlat=-90&maxlat=" +
                    "90&minlon=-180&maxlon=180&minversion=100&orderby=time-asc&format=text&limit=10000";
            
            //   crs = new CaricaReportService(this.url);
            
            obList = FXCollections.observableArrayList();
            fList = new FilteredList (obList,b -> true);
            
            alert = new Alert(Alert.AlertType.ERROR);
            
            inizializzaLimiteTxf();
            inizializzaTabella();
            inizializzaSearchBar();
            Platform.runLater(() -> caricaBtn.requestFocus());
            
            mostraDatiDB();
    }
 //carica nella obList i dati presenti nel DB
    private void mostraDatiDB(){
        try {
            obList.setAll(ingPostGres.elencaTutti());
            eventTable.setItems(fList);
            
            pi.setVisible(false);
            
            crs.reset();
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void caricaDati(ActionEvent event) {

        crs = new CaricaReportService(this.url);
        inizializzaCaricamento();
        LocalDate di = dataInizio.getValue();
        LocalDate df = dataFine.getValue();
        
        if (dataInizio.getValue() == null || dataFine.getValue() == null || di.compareTo(df) > 0) {
            
            alert.setContentText("Le date inserite non sono valide!");
            alert.showAndWait();

            event.consume();
            
            return;
        }  
        
        int limiteEventi = limiteTxf.getText().isEmpty() ? 1000 : Integer.parseInt(limiteTxf.getText());

        crs.setDataInizio(di);
        crs.setDataFine(df);
        crs.setLimitEvent(limiteEventi);
        
        crs.setOnSucceeded(e -> {
            List<INGEvent> eventi = crs.getValue();
            //passa a INGEventDAOPostGres la lista da aggiungere al DB
            try{
            ingPostGres.carica(eventi);
            }
            catch(Exception ex){
                System.out.println(ex.getMessage());
            }
            mostraDatiDB();
        });

        crs.setOnFailed(e -> {
            
            alert.setContentText("Impossibile caricare i dati!");
            alert.showAndWait();
            
            crs.reset();
        });

        crs.start();
    }
    
     @FXML
    private void esportaEventi(ActionEvent event) {
        
        Stage stage = (Stage) contextMenu.getOwnerWindow();
        
        List<INGEvent> export = eventTable.getSelectionModel().getSelectedItems();
        
        FileChooser fc = new FileChooser();
        fc.setTitle("Esporta eventi.");
        File file = fc.showSaveDialog(stage);
        
        if(file == null) return;
        
        try(PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file.getAbsolutePath())))) {
            
            pw.append("Date|Magnitude|Location");
            
            for(INGEvent evento : export) {
                
                pw.append(evento.getTime().toLocalDate() + "|");
                pw.append(evento.getMagnitude() + "|");
                pw.append(evento.getEventLocationName() + "\n");
            }
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Gli eventi sono stati esportati.");
            alert.showAndWait();
        } catch(IOException e) {
            
            alert.setContentText("Errore durante l'esportazione degli eventi selezionati!");
            alert.showAndWait();
        }
    }
    
    private void inizializzaTabella() {
       
        dateColumn.setCellValueFactory(new PropertyValueFactory("time"));
        magnitudeColumn.setCellValueFactory(new PropertyValueFactory("magnitude"));
        locationColumn.setCellValueFactory(new PropertyValueFactory("eventLocationName"));
        
        eventTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    private void inizializzaLimiteTxf() {
        
        limiteTxf.setTextFormatter(new TextFormatter<>(change -> {
            
            String newText = change.getControlNewText();
            
            return newText.matches("\\d*") ? change : null;
        }));

        limiteTxf.promptTextProperty().bind(
        Bindings.when(limiteTxf.textProperty().isEmpty())
            .then("1000")
            .otherwise("")
        );
    }

    private void inizializzaSearchBar() {
        
        serchBar.textProperty().addListener((obs,oldVal,newVal) -> {
        
          fList.setPredicate( filtro -> {
          
            if(newVal == null || newVal.isEmpty())return true;

            String ricerca = newVal.toLowerCase();

            if(filtro.getEventLocationName().toLowerCase().contains(ricerca) || 
               filtro.getTime().toString().toLowerCase().contains(ricerca) || 
               String.valueOf(filtro.getMagnitude()).toLowerCase().contains(ricerca)) return true;

            return false;
          });
        }); 
    }

    private void inizializzaCaricamento() {
        
        pi.progressProperty().bind(crs.progressProperty());
        
        caricamentoDati.visibleProperty().bind(pi.progressProperty().greaterThan(0.0));
        caricamentoDati.progressProperty().bind(pi.progressProperty());
        
        percentuale.visibleProperty().bind(pi.progressProperty().greaterThan(0.0));
        percentuale.textProperty().bind(
        Bindings.createStringBinding(
        () -> "Caricamento  " + (int)(pi.getProgress() * 100) + "%",
        pi.progressProperty()
    )
);
 
    }
}
