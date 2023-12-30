package com.example.orderservice;

import com.example.orderservice.Service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class OrderServiceApplicationTests {
    @Autowired
    OrderService orderService;

    @Test
    void CheckBalanceWhileOrderTest(){
        ResponseEntity a = orderService.addOrder("TXT2000","Graphic Card","3000","Ardam","5");

        assertEquals(HttpStatus.BAD_REQUEST,a.getStatusCode());
    }

    @Test
    void makeOrderTest(){
        ResponseEntity a = orderService.addOrder("TXT2000","Graphic Card","3000","Ardam","32325");
        assertEquals(HttpStatus.OK,a.getStatusCode());
    }


}
