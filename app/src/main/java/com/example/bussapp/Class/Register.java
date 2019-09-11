package com.example.bussapp.Class;

public class Register {
    private String Name;
    private int ConNo;
    private String Email;
    private String Pass;


    public Register() {
    }

    public Register(String name, int conNo, String email, String pass) {
        Name = name;
        ConNo = conNo;
        Email = email;
        Pass = pass;
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
