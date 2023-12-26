package com.example.orderservice.Service;


import com.example.orderservice.Entity.OrderEntity;
import com.example.orderservice.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<OrderEntity> getOrdersByProductName(String productName) {
        return orderRepository.findByProductName(productName);
    }
}
