package com.example.productservice;

import com.example.productservice.Service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class ProductServiceApplicationTests {
    @Autowired
    ProductService productService;

    @Test
    void contextLoads() {
    }



    @Test
    void addProduct(){
        ResponseEntity a =  productService.addProduct("TXT2000","Graphic Card","3000","Diyar","Resim");
        assertEquals(HttpStatus.OK,a.getStatusCode());
    }

    @Test
    void AddProductFailTest(){
        ResponseEntity a = productService.addProduct("3000","","","322","23");

        assertEquals(HttpStatus.BAD_REQUEST,a.getStatusCode());
    }
    @Test
    void ListProduct() throws JsonProcessingException {
       ResponseEntity a =  productService.listRelatedProduct("rtx");
        assertEquals(HttpStatus.OK,a.getStatusCode());
    }
}
