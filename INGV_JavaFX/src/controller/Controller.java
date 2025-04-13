package controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import main.CaricaReportService;
import main.INGEvent;

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
    
    private ObservableList obList;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    @FXML
    private void caricaDati(ActionEvent event) {

        String url = "https://webservices.ingv.it/fdsnws/event/1/query?starttime=2020-11-18T00%3A00%3A00&endtime=" +
                     "2020-11-25T23%3A59%3A59&minmag=2&maxmag=10&mindepth=-10&maxdepth=1000&minlat=-90&maxlat=" +
                     "90&minlon=-180&maxlon=180&minversion=100&orderby=time-asc&format=text&limit=10000";

        CaricaReportService crs = new CaricaReportService(url, 5);

        crs.setOnSucceeded(e -> {
            List<INGEvent> eventi = crs.getValue();
            
            inizializzaTabella(eventi);
        });

        crs.setOnFailed(e -> {
            Throwable errore = crs.getException();
            errore.printStackTrace();
        });

        crs.start();
    }
    
    private void inizializzaTabella(List<INGEvent> eventi) {
        
        obList = FXCollections.observableArrayList(eventi);
        
        dateColumn.setCellValueFactory(new PropertyValueFactory("time"));
        magnitudeColumn.setCellValueFactory(new PropertyValueFactory("magnitude"));
        locationColumn.setCellValueFactory(new PropertyValueFactory("eventLocationName"));
        
        eventTable.setItems(obList);
    }
}
