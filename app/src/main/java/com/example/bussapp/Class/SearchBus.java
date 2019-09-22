package com.example.bussapp.Class;

public class SearchBus {

    private String txtFrom;
    private String txtTo;
    private String txDate;
    private String txtTime;

    public SearchBus() {

    }

    public SearchBus(String txtFrom, String txtTo, String txDate, String txtTime) {
        this.txtFrom = txtFrom;
        this.txtTo = txtTo;
        this.txDate = txDate;
        this.txtTime = txtTime;
    }

    public String getTxtFrom() {
        return txtFrom;
    }

    public void setTxtFrom(String txtFrom) {
        this.txtFrom = txtFrom;
    }

    public String getTxtTo() {
        return txtTo;
    }

    public void setTxtTo(String txtTo) {
        this.txtTo = txtTo;
    }

    public String getTxDate() {
        return txDate;
    }

    public void setTxDate(String txDate) {
        this.txDate = txDate;
    }

    public String getTxtTime() {
        return txtTime;
    }

    public void setTxtTime(String txtTime) {
        this.txtTime = txtTime;
    }
}
