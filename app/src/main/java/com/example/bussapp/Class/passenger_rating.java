package com.example.bussapp.Class;

public class passenger_rating {

    private String btn_rating_submit;
    private String Passenger_ratingBar;

    public passenger_rating() {
    }

    public passenger_rating(String btn_rating_submit, String passenger_ratingBar) {
        this.btn_rating_submit = btn_rating_submit;
        Passenger_ratingBar = passenger_ratingBar;
    }

    public String getBtn_rating_submit() {
        return btn_rating_submit;
    }

    public void setBtn_rating_submit(String btn_rating_submit) {
        this.btn_rating_submit = btn_rating_submit;
    }


    public String getPassenger_ratingBar() {
        return Passenger_ratingBar;
    }

    public void setPassenger_ratingBar( String passenger_ratingBar) {
        Passenger_ratingBar = passenger_ratingBar;
    }
}
