package com.example.productservice.Response;


public class ProductResponse {



    private String productname;

    private String productdesc;


    private String productimage;
    private String productprice;

    private String productseller;

    public ProductResponse(String product_name, String product_desc, String productseller,String product_price,String product_image) {
        this.productname = product_name;
        this.productdesc = product_desc;
        this.productseller = productseller;
        this.productprice = product_price;
        this.productimage = product_image;

    }

    public String getProduct_name() {
        return productname;
    }

    public String getProduct_desc() {
        return productdesc;
    }

    public String getProductseller() {
        return productseller;
    }
    public String getProduct_image() {
        return productimage;
    }

    public String getProduct_price() {
        return productprice;
    }

}
