package com.example.bussapp.Class;

import java.lang.reflect.Type;

public class Login {

    private String UserEmail;
    private String Password;

    public Login() {
    }

    public Login(String userEmail, String password) {
        UserEmail = userEmail;
        Password = password;
    }

    public String getUserEmail() {
        return UserEmail;
    }

    public void setUserEmail(String userEmail) {
        UserEmail = userEmail;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
