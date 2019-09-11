package com.example.bussapp;

public class   RouteDetails {

    private String From;
    private String TO;
    private String StartTime;
    private String EndTime;
    private int RNumber;

    public RouteDetails() {
    }

    public RouteDetails(String from, String TO, String startTime, String endTime, int RNumber) {
        From = from;
        this.TO = TO;
        StartTime = startTime;
        EndTime = endTime;
        this.RNumber = RNumber;
    }

    public String getFrom() {
        return From;
    }

    public void setFrom(String from) {
        From = from;
    }

    public String getTO() {
        return TO;
    }

    public void setTO(String TO) {
        this.TO = TO;
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

    public int getRNumber() {
        return RNumber;
    }

    public void setRNumber(int RNumber) {
        this.RNumber = RNumber;
    }
}
