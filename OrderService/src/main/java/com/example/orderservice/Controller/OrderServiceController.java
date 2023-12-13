package com.example.orderservice.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
@CrossOrigin(origins = "http:localhost:9000")
public class OrderServiceController {
}
