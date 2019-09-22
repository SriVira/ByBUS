package com.example.bussapp.Class;

public class Register {

    private  String Name;
    private  int ConNo;
    private String Email;
    private  String Pass;

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

    public void setName(String name) {
        Name = name;
    }

    public int getConNo() {
        return ConNo;
    }

    public void setConNo(int conNo) {
        ConNo = conNo;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String pass) {
        Pass = pass;
    }
}
