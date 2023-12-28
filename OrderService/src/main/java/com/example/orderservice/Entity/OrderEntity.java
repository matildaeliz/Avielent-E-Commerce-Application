package com.example.orderservice.Entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "OrderInfo")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int orderId;

    @Column
    private String productName;

    @Column
    private String productDescription;

    @Column
    private String productPrice;

    private String productBuyer;



    public OrderEntity() {
    }

    public OrderEntity(String productName, String productDescription, String productPrice, String productBuyer) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.productBuyer =productBuyer;
    }


    public int getOrderId() {
        return orderId;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public String getProductBuyer() {
        return productBuyer;
    }
}