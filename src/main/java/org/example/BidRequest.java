package org.example;

public class BidRequest {
    private double price;
    private String userId;

    public BidRequest(String userId, double price) {
        this.userId = userId;
        this.price = price;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}