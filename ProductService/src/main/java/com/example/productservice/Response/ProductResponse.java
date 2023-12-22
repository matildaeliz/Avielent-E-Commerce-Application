package com.example.productservice.Response;

import jakarta.persistence.Column;

import java.io.File;
import java.io.FileInputStream;

public class ProductResponse {

    private String product_name;

    private String product_desc;

    private String productseller;
    private String image;


    public ProductResponse(String product_name, String product_desc, String productseller,String image) {
        this.product_name = product_name;
        this.product_desc = product_desc;
        this.productseller = productseller;
        this.image =image;

    }

    public String getProduct_name() {
        return product_name;
    }
    public String getProduct_desc(){
        return product_desc;
    }

    public String getProductseller() {
        return productseller;
    }

    public String getImage() {
        return image;
    }
}
