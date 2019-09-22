package com.example.bussapp.AdminPassenger;

public class PassengerDetails {

    private String Pname;
    private String Pcontact;
    private String Pemail;
    private String Ppassword;

    public PassengerDetails() {
    }

    public PassengerDetails(String pname, String pcontact, String pemail, String ppassword) {
        Pname = pname;
        Pcontact = pcontact;
        Pemail = pemail;
        Ppassword = ppassword;
    }

    public String getPname() {
        return Pname;
    }

    public void setPname(String pname) {
        Pname = pname;
    }

    public String getPcontact() {
        return Pcontact;
    }

    public void setPcontact(String pcontact) {
        Pcontact = pcontact;
    }

    public String getPemail() {
        return Pemail;
    }

    public void setPemail(String pemail) {
        Pemail = pemail;
    }

    public String getPpassword() {
        return Ppassword;
    }

    public void setPpassword(String ppassword) {
        Ppassword = ppassword;
    }
}
