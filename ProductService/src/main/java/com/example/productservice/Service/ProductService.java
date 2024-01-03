package com.example.productservice.Service;

import com.example.productservice.Entity.ProductEntity;
import com.example.productservice.Repository.ProductRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {
       @Autowired
     public ProductRepository productRepository;

    public ResponseEntity addProduct(String name, String desc, String price, String seller, String image){
        if (name == null || desc == null || price == null || image == null || name=="" ||desc=="" || price ==""||image=="") {
            return ResponseEntity.badRequest().build();
        }else{
            productRepository.save(new ProductEntity(name,desc,price,seller,image));

            return ResponseEntity.ok("");
        }

    }


    public ResponseEntity listRelatedProduct(String productname) throws JsonProcessingException {
        ArrayList<ProductEntity> list = productRepository.getRelatedProduct(productname);
        ObjectMapper objectMapper = new ObjectMapper();
        if(list.isEmpty()){
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(objectMapper.writeValueAsString(list));
    }

    public ResponseEntity calculateAverageofStar(int star, int id){
        try {
            if(star > 5 || star < 0 ){
                return ResponseEntity.badRequest().build();
            } else {


                if(productRepository.getStarCountbyid(id) == 0){
                    productRepository.updateCountbyid(id);
                    productRepository.updateStarbyid(id,star);
                    productRepository.updateTotalStarbyid(id,star);
                    return  ResponseEntity.ok("");
                }else{
                    int gettotalstar = productRepository.getTotalStarbyid(id)+star;
                    productRepository.updateCountbyid(id);
                    int getcount = productRepository.getStarCountbyid(id);
                    double newstar = gettotalstar/getcount;
                    productRepository.updateTotalStarbyid(id,gettotalstar);
                    productRepository.updateStarbyid(id,newstar);
                    return ResponseEntity.ok("");
                }





            }

        }catch (NumberFormatException numberFormatException){
            return ResponseEntity.badRequest().build();
        }
    }

}
