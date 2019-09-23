package com.example.bussapp;

public class Driver_RouteDetails {
    private String From;
    private String To;
    private String StartTime;
    private String EndTime;
    private String RNumber;
    private String ID;

    public Driver_RouteDetails() {
    }

    public Driver_RouteDetails(String from, String to, String startTime, String endTime, String RNumber,String ID) {
        this.From = from;
        this.To = to;
        this.StartTime = startTime;
        this.EndTime = endTime;
        this.RNumber = RNumber;
        this.ID=ID;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFrom() {
        return From;
    }

    public void setFrom(String from) {
        From = from;
    }

    public String getTo() {
        return To;
    }

    public void setTo(String to) {
        To = to;
    }

    public String getStartTime() {
        return StartTime;
    }

    public void setStartTime(String startTime) {
        StartTime = startTime;
    }

    public String getEndTime() {
        return EndTime;
    }

    public void setEndTime(String endTime) {
        EndTime = endTime;
    }

    public String getRNumber() {
        return RNumber;
    }

    public void setRNumber(String RNumber) {
        this.RNumber = RNumber;
    }
}
