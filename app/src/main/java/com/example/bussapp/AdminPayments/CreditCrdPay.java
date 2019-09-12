package com.example.bussapp.AdminPayments;

public class CreditCrdPay {
    private String CrdHName;
    private int CrdNo;
    private int CVC;
    private String ExpDate;

    public CreditCrdPay() {
    }

    public CreditCrdPay(String crdHName, int crdNo, int CVC, String expDate) {
        CrdHName = crdHName;
        CrdNo = crdNo;
        this.CVC = CVC;
        ExpDate = expDate;
    }

    public String getCrdHName() {
        return CrdHName;
    }

    public void setCrdHName(String crdHName) {
        CrdHName = crdHName;
    }

    public int getCrdNo() {
        return CrdNo;
    }

    public void setCrdNo(int crdNo) {
        CrdNo = crdNo;
    }

    public int getCVC() {
        return CVC;
    }

    public void setCVC(int CVC) {
        this.CVC = CVC;
    }

    public String getExpDate() {
        return ExpDate;
    }

    public void setExpDate(String expDate) {
        ExpDate = expDate;
    }
}
