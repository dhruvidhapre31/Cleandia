package models;

public class NotificationModel {
    String eventDate, eventMonth, eventName, ngoName;

    public NotificationModel(String eventDate, String eventMonth, String eventName, String ngoName) {
        this.eventDate = eventDate;
        this.eventMonth = eventMonth;
        this.eventName = eventName;
        this.ngoName = ngoName;
    }

    public String getEventDate() {
        return eventDate;
    }
    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }
    public String getEventMonth() {
        return eventMonth;
    }
    public void setEventMonth(String eventMonth) {
        this.eventMonth = eventMonth;
    }
    public String getEventName() {
        return eventName;
    }
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
    public String getNgoName() {
        return ngoName;
    }
    public void setNgoName(String ngoName) {
        this.ngoName = ngoName;
    }
}
