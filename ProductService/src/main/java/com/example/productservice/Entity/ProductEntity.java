package com.example.productservice.Entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;


@Entity
@Table(name = "ProductInfo")
public class ProductEntity  {
    @JsonProperty("id")
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 65555)
    private String product_image;
    @Column
    private String product_name;
    @Column
    private String product_desc;
    @Column
    private String product_price;
    @Column
    private double product_star;

    @Column
    private int product_starcount;
    @Column
    private String productseller;

    public ProductEntity(String product_name, String product_desc, String product_price, String productseller, String product_image) {
        this.product_name = product_name;
        this.product_desc = product_desc;
        this.product_star = 0.0;
        this.productseller = productseller;
        this.product_price = product_price;
        this.product_image =product_image;
        this.product_starcount = 0;


    }

    public ProductEntity() {

    }


    public String getProduct_image() {
        return product_image;
    }

    public String getProduct_name() {
        return product_name;
    }

    public String getProduct_desc() {
        return product_desc;
    }

    public String getProduct_price() {
        return product_price;
    }

    public double getProduct_star() {
        return product_star;
    }

    public String getProductseller() {
        return productseller;
    }

}