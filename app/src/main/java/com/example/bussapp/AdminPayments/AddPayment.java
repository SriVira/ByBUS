package com.example.bussapp.AdminPayments;

public class AddPayment {
    private String Cname;
    private int Cno;
    private int Cvc;
    private String Exp;

    public AddPayment() {
    }

    public AddPayment(String cname, int cno, int cvc, String exp) {
        Cname = cname;
        Cno = cno;
        Cvc = cvc;
        Exp = exp;
    }

    public String getCname() {
        return Cname;
    }

    public void setCname(String cname) {
        Cname = cname;
    }

    public int getCno() {
        return Cno;
    }

    public void setCno(int cno) {
        Cno = cno;
    }

    public int getCvc() {
        return Cvc;
    }

    public void setCvc(int cvc) {
        Cvc = cvc;
    }

    public String getExp() {
        return Exp;
    }

    public void setExp(String exp) {
        Exp = exp;
    }
}
