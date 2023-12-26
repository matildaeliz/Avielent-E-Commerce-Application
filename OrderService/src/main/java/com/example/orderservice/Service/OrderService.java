package com.example.orderservice.Service;


import com.example.orderservice.Entity.OrderEntity;
import com.example.orderservice.Repository.OrderRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
}
