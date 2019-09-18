package com.example.bussapp;

public class DriverProfile {
    private String BusNo;
    private String DriverName;
    private String ContactNo;
    private String DriverLicensNo;
    private String Email;
    private String SeatsCount;

    public DriverProfile() {

    }

    public DriverProfile(String busNo, String driverName, String contactNo, String driverLicensNo, String email,String seatsCount) {
        BusNo = busNo;
        DriverName = driverName;
        ContactNo = contactNo;
        DriverLicensNo = driverLicensNo;
        Email = email;
        this.SeatsCount =seatsCount;
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
        return DriverName;
    }

    public void setDriverName(String driverName) {
        DriverName = driverName;
    }

    public String getContactNo() {
        return ContactNo;
    }

    public void setContactNo(String contactNo) {
        ContactNo = contactNo;
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
