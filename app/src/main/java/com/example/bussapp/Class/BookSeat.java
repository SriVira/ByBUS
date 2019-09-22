package com.example.bussapp.Class;

public class BookSeat {

    private int seatNo;
    private String txtSBusNo,txtSDName,txtSConNo,txtSfrom,txtSto,txtSDTime,txtSArTime,txtSBookedSeats,txtSAvailabeSeates,txtrouteNo,txtDate,txtPay;

    public BookSeat() {
    }

    public BookSeat(int seatNo, String txtSBusNo, String txtSDName, String txtSConNo, String txtSfrom, String txtSto, String txtSDTime, String txtSArTime, String txtSBookedSeats, String txtSAvailabeSeates, String txtrouteNo, String txtDate, String txtPay) {
        this.seatNo = seatNo;
        this.txtSBusNo = txtSBusNo;
        this.txtSDName = txtSDName;
        this.txtSConNo = txtSConNo;
        this.txtSfrom = txtSfrom;
        this.txtSto = txtSto;
        this.txtSDTime = txtSDTime;
        this.txtSArTime = txtSArTime;
        this.txtSBookedSeats = txtSBookedSeats;
        this.txtSAvailabeSeates = txtSAvailabeSeates;
        this.txtrouteNo = txtrouteNo;
        this.txtDate = txtDate;
        this.txtPay = txtPay;
    }

    public int getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(int seatNo) {
        this.seatNo = seatNo;
    }

    public String getTxtSBusNo() {
        return txtSBusNo;
    }

    public void setTxtSBusNo(String txtSBusNo) {
        this.txtSBusNo = txtSBusNo;
    }

    public String getTxtSDName() {
        return txtSDName;
    }

    public void setTxtSDName(String txtSDName) {
        this.txtSDName = txtSDName;
    }

    public String getTxtSConNo() {
        return txtSConNo;
    }

    public void setTxtSConNo(String txtSConNo) {
        this.txtSConNo = txtSConNo;
    }

    public String getTxtSfrom() {
        return txtSfrom;
    }

    public void setTxtSfrom(String txtSfrom) {
        this.txtSfrom = txtSfrom;
    }

    public String getTxtSto() {
        return txtSto;
    }

    public void setTxtSto(String txtSto) {
        this.txtSto = txtSto;
    }

    public String getTxtSDTime() {
        return txtSDTime;
    }

    public void setTxtSDTime(String txtSDTime) {
        this.txtSDTime = txtSDTime;
    }

    public String getTxtSArTime() {
        return txtSArTime;
    }

    public void setTxtSArTime(String txtSArTime) {
        this.txtSArTime = txtSArTime;
    }

    public String getTxtSBookedSeats() {
        return txtSBookedSeats;
    }

    public void setTxtSBookedSeats(String txtSBookedSeats) {
        this.txtSBookedSeats = txtSBookedSeats;
    }

    public String getTxtSAvailabeSeates() {
        return txtSAvailabeSeates;
    }

    public void setTxtSAvailabeSeates(String txtSAvailabeSeates) {
        this.txtSAvailabeSeates = txtSAvailabeSeates;
    }

    public String getTxtrouteNo() {
        return txtrouteNo;
    }

    public void setTxtrouteNo(String txtrouteNo) {
        this.txtrouteNo = txtrouteNo;
    }

    public String getTxtDate() {
        return txtDate;
    }

    public void setTxtDate(String txtDate) {
        this.txtDate = txtDate;
    }

    public String getTxtPay() {
        return txtPay;
    }

    public void setTxtPay(String txtPay) {
        this.txtPay = txtPay;
    }
}
