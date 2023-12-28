package com.example.orderservice.Controller;

import com.example.orderservice.Entity.OrderEntity;
import com.example.orderservice.Response.OrderResponse;
import com.example.orderservice.Service.OrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("order")
@CrossOrigin(origins = "http:localhost:9000")
public class OrderController {

    private final OrderService orderService;





    @Autowired
    public OrderController(OrderService orderService) {
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

    @GetMapping("/addOrder")
    public ResponseEntity addOrder(@RequestParam("pname")String pname,@RequestParam("pdesc")String pdesc,@RequestParam("pprice")String pprice,@RequestParam("buyer")String buyer,@RequestParam("balance")String balance){
      return orderService.addOrder(pname, pdesc, pprice, buyer, balance);
    }



}