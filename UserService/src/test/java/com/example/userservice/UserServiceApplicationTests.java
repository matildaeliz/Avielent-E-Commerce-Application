package com.example.userservice;

import com.example.userservice.Response.UserResponse;
import com.example.userservice.Service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class UserServiceApplicationTests {
    @Autowired
 UserService userService;
    @Test
    void contextLoads() {
    }
@Test



   void createUsername(){
      ResponseEntity a =  userService.addUser(new UserResponse("ardafhgh5tghg","3232","ardaonur15",0));

          assertEquals(a.getStatusCode(),HttpStatus.OK);
   }
}
