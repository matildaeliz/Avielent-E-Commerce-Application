package com.example.userservice;

import com.example.userservice.Entity.UserEntity;
import com.example.userservice.Repository.UserRepository;
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
    @Autowired
    UserRepository userRepository;
    @Test
    void contextLoads() {
    }
@Test
   void createAccountTest(){
        ResponseEntity a =  userService.addUser(new UserResponse("erer","3232","metelax",0));

          assertEquals(HttpStatus.OK,a.getStatusCode());


   }
    @Test
    void createAccountErrorTest(){
        ResponseEntity a =  userService.addUser(new UserResponse("mete","3232","metelax",0));
        ResponseEntity b =  userService.addUser(new UserResponse("mete","3232","metelax",0));
        assertEquals(HttpStatus.BAD_REQUEST,b.getStatusCode());


    }
   @Test
    void updateBalanceFailTest(){
        ResponseEntity a = UptB(-3999);
        assertEquals(HttpStatus.BAD_REQUEST,a.getStatusCode());
   }
    @Test
    void updateBalanceTest(){
        ResponseEntity a = UptB(4000);
        assertEquals(HttpStatus.OK,a.getStatusCode());
    }
   @Test
   void changePasswordTest(){
        ResponseEntity a =  chngP("3232");

        assertEquals(HttpStatus.OK,a.getStatusCode());
   }
   ResponseEntity chngP(String pass){
       userRepository.updatePassword("ardam",pass);
       return ResponseEntity.ok("Password changed");
   }
   ResponseEntity UptB(int balance){
       try{
           if (balance <= 0){
               return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
           }else {

               int newbalance = userRepository.getBalance("ardam") + balance;
               userRepository.updateBalance("ardam",newbalance);
               return ResponseEntity.ok("Balance Updated");
           }
       }catch (NumberFormatException exception){
           return  ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
       }
   }
}



