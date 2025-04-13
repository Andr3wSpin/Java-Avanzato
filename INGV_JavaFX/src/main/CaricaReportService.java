package main;

public class CaricaReportService {

    private String url;
    private  int limitEvent;

    public CaricaReportService(String url, int limitEvent) {
        this.url = url;
        this.limitEvent = limitEvent;
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
}
