package model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class CaricaReportService extends Service<List<INGEvent>> {

    private String url;
    private int limitEvent;
    private LocalDate dataInizio;
    private LocalDate dataFine;

    public CaricaReportService(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getLimitEvent() {
        return limitEvent;
    }

    public void setLimitEvent(int limitEvent) {
        this.limitEvent = limitEvent;
    }

    public LocalDate getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
    }

    public LocalDate getDataFine() {
        return dataFine;
    }

    public void setDataFine(LocalDate dataFine) {
        this.dataFine = dataFine;
    }
    
    @Override
    protected Task<List<INGEvent>> createTask() {

        return new Task<List<INGEvent>>() {
            @Override
            protected List<INGEvent> call() throws Exception {

                URL u = new URL(url);
                List<INGEvent> eventi;
              int[] i={0};
                BufferedReader in = new BufferedReader(new InputStreamReader(u.openStream()));
                  in.readLine();
                  eventi = in.lines().map(f -> {
                                      //se l operazione è troppo breve i++ e inutile uso thread.sleep per vedere l effetto
               
                                               i[0]++;
                                               updateProgress(i[0],50);
                                               INGEvent evento = creaEvento(f) ;
                                               return evento;
                                                                   }).filter(f-> 
                          !f.getTime().toLocalDate().isAfter(dataFine) && !f.getTime().toLocalDate().isBefore(dataInizio))
                          .limit(limitEvent).collect(Collectors.toList());
             updateProgress(1,1);
                try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(CaricaReportService.class.getName()).log(Level.SEVERE, null, ex);
                    }
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
