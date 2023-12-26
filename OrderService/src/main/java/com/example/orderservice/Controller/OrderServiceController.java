package com.example.orderservice.Controller;

import com.example.orderservice.Entity.OrderEntity;
import com.example.orderservice.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("order")
@CrossOrigin(origins = "http:localhost:9000")
public class OrderServiceController {

    private final OrderService orderService;

    @Autowired
    public OrderServiceController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/getOrderByProductName")
    public ResponseEntity<OrderEntity> getOrderByProductName(@RequestParam("productName") String productName) {
        OrderEntity order = orderService.getOrderEntityByProductName(productName);
        if (order != null) {
            return ResponseEntity.ok(order);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}