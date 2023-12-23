package com.example.orderservice.Entity;
import jakarta.persistence.*;
public class OrderEntity {
    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.IDENTIFY)
    private int order_id;

    public OrderEntity(){

    }


}