package com.example.productservice.Controller;

import com.example.productservice.Service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
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
          @GetMapping("/getProducts")
        public ResponseEntity getRelatedProducts(@RequestParam("productname") String productname) throws JsonProcessingException {

            return productService.listRelatedProduct(productname);

        }
        @GetMapping("/calculateAverage")
        ResponseEntity calculateAverage(@RequestParam String star, @RequestParam String id){

            return productService.calculateAverageofStar(Integer.parseInt(star),Integer.parseInt(id));

        }
}
