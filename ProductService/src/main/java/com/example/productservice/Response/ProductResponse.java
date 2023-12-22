package com.example.productservice.Response;

import jakarta.persistence.Column;

public class ProductResponse {

    private String product_name;

    private String product_desc;

    private String productseller;

    public ProductResponse(String product_name, String product_desc, String productseller) {
        this.product_name = product_name;
        this.product_desc = product_desc;
        this.productseller = productseller;

    }
}
