package com.example.orderservice.Controller;

import com.example.orderservice.Entity.OrderEntity;
import com.example.orderservice.Service.OrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @GetMapping("/getProducts")
    public String getRelatedProducts(@RequestParam("productname") String productname) throws JsonProcessingException {
        OrderEntity order = orderService.getOrderEntityByProductName(productname);
        if (order != null) {
            return orderService.convertOrderEntityToJson(order);
        } else {
            return "Product not found";
        }
    }
}