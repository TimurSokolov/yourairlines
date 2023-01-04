package com.airlines.yourairlines.dto;

public class Client extends User {
    private String email;
    private String cardNumber;
    private String homeAirport;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getHomeAirport() {
        return homeAirport;
    }

    public void setHomeAirport(String homeAirport) {
        this.homeAirport = homeAirport;
    }
}
