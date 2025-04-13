package main;



import java.time.LocalDateTime;

public class INGEvent {

    private int EventID;
    private LocalDateTime Time;
    private double Latidutne;
    private double Longitudine;
    private double Depth;
    private String Author;
    private String Catalog;
    private String Contributor;
    private float ContributorID;
    private String MagType;
    private int Magnitude;
    private char MagAuthor;
    private String EventLocationName;
    private String EventType;


    public INGEvent(LocalDateTime time, int eventID, double latidutne, double longitudine, double depth, String author, String catalog, String contributor, float contributorID, String magType, int magnitude, char magAuthor, String eventLocationName, String eventType) {
        Time = time;
        EventID = eventID;
        Latidutne = latidutne;
        Longitudine = longitudine;
        Depth = depth;
        Author = author;
        Catalog = catalog;
        Contributor = contributor;
        ContributorID = contributorID;
        MagType = magType;
        Magnitude = magnitude;
        MagAuthor = magAuthor;
        EventLocationName = eventLocationName;
        EventType = eventType;
    }


    public LocalDateTime getTime() {
        return Time;
    }

    public void setTime(LocalDateTime time) {
        Time = time;
    }

    public int getEventID() {
        return EventID;
    }

    public void setEventID(int eventID) {
        EventID = eventID;
    }

    public double getLatidutne() {
        return Latidutne;
    }

    public void setLatidutne(double latidutne) {
        Latidutne = latidutne;
    }

    public double getLongitudine() {
        return Longitudine;
    }

    public void setLongitudine(double longitudine) {
        Longitudine = longitudine;
    }

    public double getDepth() {
        return Depth;
    }

    public void setDepth(double depth) {
        Depth = depth;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getCatalog() {
        return Catalog;
    }

    public void setCatalog(String catalog) {
        Catalog = catalog;
    }

    public String getContributor() {
        return Contributor;
    }

    public void setContributor(String contributor) {
        Contributor = contributor;
    }

    public float getContributorID() {
        return ContributorID;
    }

    public void setContributorID(float contributorID) {
        ContributorID = contributorID;
    }

    public String getMagType() {
        return MagType;
    }

    public void setMagType(String magType) {
        MagType = magType;
    }

    public int getMagnitude() {
        return Magnitude;
    }

    public void setMagnitude(int magnitude) {
        Magnitude = magnitude;
    }

    public char getMagAuthor() {
        return MagAuthor;
    }

    public void setMagAuthor(char magAuthor) {
        MagAuthor = magAuthor;
    }

    public String getEventLocationName() {
        return EventLocationName;
    }

    public void setEventLocationName(String eventLocationName) {
        EventLocationName = eventLocationName;
    }

    public String getEventType() {
        return EventType;
    }

    public void setEventType(String eventType) {
        EventType = eventType;
    }



}
