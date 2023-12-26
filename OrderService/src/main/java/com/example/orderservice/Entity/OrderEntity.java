package com.example.orderservice.Entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "OrderInfo")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @Column
    private String productName;

    @Column
    private String productDescription;

    @Column
    private String productPrice;

    public OrderEntity() {
    }

    public OrderEntity(String productName, String productDescription, String productPrice) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
    }


    public Long getOrderId() {
        return orderId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

}