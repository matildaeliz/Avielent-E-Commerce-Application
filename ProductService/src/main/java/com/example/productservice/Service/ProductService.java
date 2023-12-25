package com.example.productservice.Service;

import com.example.productservice.Entity.ProductEntity;
import com.example.productservice.Repository.ProductRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {
       @Autowired
     public ProductRepository productRepository;

    public ResponseEntity addProduct(String name, String desc, String price, String seller, String image){
       productRepository.save(new ProductEntity(name,desc,price,seller,image));

       return ResponseEntity.ok("");
    }


    public String listRelatedProduct(String productname) throws JsonProcessingException {
        ArrayList<ProductEntity> list = productRepository.getRelatedProduct(productname);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(list);
    }

}
