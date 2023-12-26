package com.example.orderservice.Controller;

import com.example.orderservice.Entity.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("order")
@CrossOrigin(origins = "http:localhost:9000")
public class OrderServiceController {

    @Autowired
    private OrderServiceController orderServiceController;

    @GetMapping("/getOrdersByProductName")
    public ResponseEntity<List<OrderEntity>> getOrdersByProductName(@RequestParam("productName") String productName) {
        List<OrderEntity> orders = (List<OrderEntity>) orderServiceController.getOrdersByProductName(productName);
        return ResponseEntity.ok(orders);
    }

}