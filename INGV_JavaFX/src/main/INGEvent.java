package main;

import java.time.LocalDateTime;

public class INGEvent {

    private String eventID;
    private LocalDateTime time;
    private double latitude;
    private double longitude;
    private double depth;
    private String author;
    private String catalog;
    private String contributor;
    private String contributorID;
    private String magType;
    private double magnitude;
    private String magAuthor;
    private String eventLocationName;
    private String eventType;

    public INGEvent(String eventID, LocalDateTime time, double latitude, double longitude, double depth, String author, String catalog, String contributor, String contributorID, String magType, double magnitude, String magAuthor, String eventLocationName, String eventType) {
        this.eventID = eventID;
        this.time = time;
        this.latitude = latitude;
        this.longitude = longitude;
        this.depth = depth;
        this.author = author;
        this.catalog = catalog;
        this.contributor = contributor;
        this.contributorID = contributorID;
        this.magType = magType;
        this.magnitude = magnitude;
        this.magAuthor = magAuthor;
        this.eventLocationName = eventLocationName;
        this.eventType = eventType;
    }

    public String getEventID() {
        return eventID;
    }

    public void setEventID(String eventID) {
        this.eventID = eventID;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    public String getContributor() {
        return contributor;
    }

    public void setContributor(String contributor) {
        this.contributor = contributor;
    }

    public String getContributorID() {
        return contributorID;
    }

    public void setContributorID(String contributorID) {
        this.contributorID = contributorID;
    }

    public String getMagType() {
        return magType;
    }

    public void setMagType(String magType) {
        this.magType = magType;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
    }

    public String getMagAuthor() {
        return magAuthor;
    }

    public void setMagAuthor(String magAuthor) {
        this.magAuthor = magAuthor;
    }

    public String getEventLocationName() {
        return eventLocationName;
    }

    public void setEventLocationName(String eventLocationName) {
        this.eventLocationName = eventLocationName;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    @Override
public String toString() {
    return "INGEvent {" +
           "\n  eventID            = " + eventID +
           "\n  time               = " + time +
           "\n  latitude           = " + latitude +
           "\n  longitude          = " + longitude +
           "\n  depth              = " + depth +
           "\n  author             = " + author +
           "\n  catalog            = " + catalog +
           "\n  contributor        = " + contributor +
           "\n  contributorID      = " + contributorID +
           "\n  magType            = " + magType +
           "\n  magnitude          = " + magnitude +
           "\n  magAuthor          = " + magAuthor +
           "\n  eventLocationName  = " + eventLocationName +
           "\n  eventType          = " + eventType +
           "\n}";
}

}
