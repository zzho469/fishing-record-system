package com.jordan;

public class Record {
    private int id;
    private String date;
    private String location;
    private String fishType;
    private int sizeCm;
    private String baitUsed;
    private String notes;

    // getters 和 setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getFishType() { return fishType; }
    public void setFishType(String fishType) { this.fishType = fishType; }

    public int getSizeCm() { return sizeCm; }
    public void setSizeCm(int sizeCm) { this.sizeCm = sizeCm; }

    public String getBaitUsed() { return baitUsed; }
    public void setBaitUsed(String baitUsed) { this.baitUsed = baitUsed; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    @Override
    public String toString() {
        return date + " - " + fishType + " (" + sizeCm + "cm) @ " + location;
    }
}
