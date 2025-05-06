package model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class CaricaReportService extends Service<List<INGEvent>> {

    private String url;

    public CaricaReportService(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
   
    @Override
    protected Task<List<INGEvent>> createTask() {

        return new Task<List<INGEvent>>() {
            
            @Override
            protected List<INGEvent> call() throws Exception {

                URL u = new URL(url);
                
                List<INGEvent> eventi;
                
                final  int[] i = {0};
              
                BufferedReader in = new BufferedReader(new InputStreamReader(u.openStream()));
                
                in.readLine();
                
                eventi = in.lines().map(f -> {
                    i[0]++;
                    Platform.runLater(() -> updateProgress(i[0], 1));
                    INGEvent evento = creaEvento(f) ;
                    return evento;
                }).collect(Collectors.toList());
                
                Platform.runLater(() -> updateProgress(1, 1));
            
                return eventi;
            }
        };
    }
    
    private INGEvent creaEvento(String line) {
        
        String[] campi = line.split("\\|");

        String eventID = campi[0];
        LocalDateTime time = LocalDateTime.parse(campi[1]);
        double latitude = Double.parseDouble(campi[2]);
        double longitude = Double.parseDouble(campi[3]);
        double depth = Double.parseDouble(campi[4]);
        String author = campi[5];
        String catalogue = campi[6];
        String contributor = campi[7];
        String contributorID = campi[8];
        String magType = campi[9];
        double magnitude = Double.parseDouble(campi[10]);
        String magAuthor = campi[11];
        String eventLocation = campi[12];
        String eventType = campi[13];

        return new INGEvent(
                        eventID, time, latitude, longitude, depth,
                        author, catalogue, contributor, contributorID,
                        magType, magnitude, magAuthor, eventLocation, eventType
                    );
    }
}
