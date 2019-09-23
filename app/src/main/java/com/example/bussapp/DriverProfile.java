package com.example.bussapp;

public class DriverProfile {
    private String BusNo;
    private String Name;
    private int ConNo;
    private String DriverLicensNo;
    private String Email;
    private String SeatsCount;

    public DriverProfile() {

    }

    public DriverProfile(String busNo, String name, int conNo, String driverLicensNo, String email,String seatsCount) {
        BusNo = busNo;
        Name = name;
        ConNo = conNo;
        DriverLicensNo = driverLicensNo;
        Email = email;
        SeatsCount =seatsCount;
    }

    public String getSeatsCount() {
        return SeatsCount;
    }

    public void setSeatsCount(String seatsCount) {
        SeatsCount = seatsCount;
    }

    public String getBusNo() {
        return BusNo;
    }

    public void setBusNo(String busNo) {
        BusNo = busNo;
    }

    public String getDriverName() {
        return Name;
    }

    public void setDriverName(String name) {
        Name = name;
    }

    public int getContactNo() {
        return ConNo;
    }

    public void setContactNo(int conNo) {
        ConNo = conNo;
    }

    public String getDriverLicensNo() {
        return DriverLicensNo;
    }

    public void setDriverLicensNo(String driverLicensNo) {
        DriverLicensNo = driverLicensNo;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
