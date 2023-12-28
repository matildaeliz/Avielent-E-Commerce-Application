package com.example.orderservice.Service;


import com.example.orderservice.Entity.OrderEntity;
import com.example.orderservice.Repository.OrderRepository;
import com.example.orderservice.Response.OrderResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class OrderService {

    private final OrderRepository orderRepository;





    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public OrderEntity getOrderEntityByProductName(String productName) {
        return orderRepository.findByProductName(productName);
    }

    public String convertOrderEntityToJson(OrderEntity order) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(order);
    }


    public ResponseEntity addOrder(String name, String desc, String price ,String buyer, String balance){
        if(Integer.parseInt(balance)< Integer.parseInt(price)){
            return ResponseEntity.badRequest().build();
        }else{
            orderRepository.save(new OrderEntity(name,desc,price,buyer));
            return ResponseEntity.status(HttpStatus.OK).build();
        }
    }
}
