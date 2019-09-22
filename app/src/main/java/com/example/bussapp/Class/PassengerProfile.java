package com.example.bussapp.Class;

public class PassengerProfile {

    private String txtPName;
    private String txtPContact;
    private String txtPEmail;

    public PassengerProfile() {

    }

    public PassengerProfile(String txtPName, String txtPContact, String txtPEmail) {
        this.txtPName = txtPName;
        this.txtPContact = txtPContact;
        this.txtPEmail = txtPEmail;
    }

    public String getTxtPName() {
        return txtPName;
    }

    public void setTxtPName(String txtPName) {
        this.txtPName = txtPName;
    }

    public String getTxtPContact() {
        return txtPContact;
    }

    public void setTxtPContact(String txtPContact) {
        this.txtPContact = txtPContact;
    }

    public String getTxtPEmail() {
        return txtPEmail;
    }

    public void setTxtPEmail(String txtPEmail) {
        this.txtPEmail = txtPEmail;
    }
}
