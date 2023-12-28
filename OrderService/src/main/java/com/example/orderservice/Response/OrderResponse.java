package com.example.orderservice.Response;

public class OrderResponse {

    private String productName;
    private String productDescription;

    private String productPrice;

    private String productBuyer;


    private String balance;

    public OrderResponse(String productName, String productDescription, String productPrice, String productBuyer, String balance) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.productBuyer = productBuyer;
        this.balance = balance;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public String getBalance() {
        return balance;
    }

    public String getProductBuyer() {
        return productBuyer;
    }
    public String getProductPrice() {
        return productPrice;
    }

}
