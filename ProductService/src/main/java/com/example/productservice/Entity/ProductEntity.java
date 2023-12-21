package com.example.productservice.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ProductInfo")
public class ProductEntity {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String product_name;
    @Column
    private String product_desc;
    @Column
    private double product_star;

    public ProductEntity(String product_name, String product_desc) {
        this.product_name = product_name;
        this.product_desc = product_desc;
        this.product_star = 0.0;

    }

    public ProductEntity() {

    }
}