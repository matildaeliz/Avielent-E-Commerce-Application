package com.example.productservice.Controller;

import com.example.productservice.Response.ProductResponse;
import com.example.productservice.Service.ProductService;
import org.apache.http.protocol.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@RestController
@RequestMapping("product")
@CrossOrigin(origins = "http://localhost:8080")
public class ProductController {

    @Autowired
     private ProductService productService;



        @PostMapping("/postPhoto")
        public ResponseEntity SendProduct(@RequestPart("file") MultipartFile multipartFile, @RequestPart("productname") String name,
                                @RequestPart("productdescription") String description, @RequestPart("productprice") String price,
                                 @RequestPart("username")String username) throws IOException {


             return productService.addProduct(name,description,price,username,Base64.getEncoder().encodeToString(multipartFile.getBytes()));
        }
}
