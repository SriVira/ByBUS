package com.example.bussapp.Class;

public class Register {
    private String Name;
    private int ConNo;
    private String Email;
    private String Pass;
    private String RadioButton1;
    private String RadioButton2;


    public Register() {
    }

    public Register(String name, int conNo, String email, String pass, String RadioButton1,String RadioButton2) {
        Name = name;
        ConNo = conNo;
        Email = email;
        Pass = pass;
        RadioButton1 = RadioButton1;
        RadioButton2= RadioButton2;


    }

    public String getRadioButton1() {
        return RadioButton1;
    }

    public void setRadioButton1(String radioButton1) {
        RadioButton1 = radioButton1;
    }

    public String getRadioButton2() {
        return RadioButton2;
    }

    public void setRadioButton2(String radioButton2) {
        RadioButton2 = radioButton2;
    }

    public String getName() {
        return Name;
    }

    public int getConNo() {
        return ConNo;
    }

    public String getEmail() {
        return Email;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String pass) {
        Pass = pass;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setConNo(int conNo) {
        ConNo = conNo;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
