package com.example.orderservice.Response;

public class OrderResponse {

    private String productName;
    private String productDescription;
    private String productImage;
    private String productPrice;
    private String productSeller;

    public OrderResponse(String productName, String productDescription, String productSeller, String productPrice, String productImage) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productSeller = productSeller;
        this.productPrice = productPrice;
        this.productImage = productImage;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public String getProductSeller() {
        return productSeller;
    }

    public String getProductImage() {
        return productImage;
    }

    public String getProductPrice() {
        return productPrice;
    }
}
