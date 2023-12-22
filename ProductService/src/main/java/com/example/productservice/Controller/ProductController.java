package com.example.productservice.Controller;


import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import java.util.Base64;


@RestController
@RequestMapping("product")
@CrossOrigin(origins = "http://localhost:8080")
public class ProductController {

    @PostMapping("/postPhoto")
    public void uploadPhoto(@RequestPart("file")MultipartFile file) throws IOException {
      String image = Base64.getEncoder().encodeToString(file.getBytes());

    }
}
