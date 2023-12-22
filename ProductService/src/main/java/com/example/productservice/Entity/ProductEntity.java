package com.example.productservice.Entity;

import jakarta.persistence.*;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.nio.file.FileSystem;
import java.nio.file.Files;

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
    @Column
    private String productseller;
    @Column
    private String image;


    public ProductEntity(String product_name, String product_desc, String productseller, String image) {
        this.product_name = product_name;
        this.product_desc = product_desc;
        this.product_star = 0.0;
        this.productseller = productseller;
        this.image = image;

    }

    public ProductEntity() {

    }
}