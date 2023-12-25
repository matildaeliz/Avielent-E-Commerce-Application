package com.example.productservice.Service;

import com.example.productservice.Entity.ProductEntity;
import com.example.productservice.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
       @Autowired
     public ProductRepository productRepository;

    public ResponseEntity addProduct(String name, String desc, String price, String seller, String image){
       productRepository.save(new ProductEntity(name,desc,price,seller,image));

       return ResponseEntity.ok("");
    }


}
