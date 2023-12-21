package com.example.userservice.Controller;

import com.example.userservice.Response.UserResponse;
import com.example.userservice.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("user")

public class UserServiceController {
         @Autowired
         UserService userService;

           @PostMapping("/register")
         public ResponseEntity addUser(@RequestBody UserResponse userResponse){
               return userService.addUser(userResponse);
         }
            @PostMapping("/login")
         public ResponseEntity authorization(@RequestBody UserResponse userResponse){
             return  userService.authorization(userResponse.getUsername(),userResponse.getPassword());
         }
       @PostMapping("/changePassword")
    public ResponseEntity changePassword(@RequestBody UserResponse userResponse){
        return  userService.changePassword(userResponse.getPassword());
    }

    @PostMapping("/changeEmail")
    public ResponseEntity changeEmail(@RequestBody UserResponse userResponse){
        return  userService.changeEmail(userResponse.getEmail());
    }
    @PostMapping("/updateBalance")
    public ResponseEntity updateBalance(@RequestBody UserResponse userResponse){
        return  userService.updateBalance(userResponse.getBalance());
    }
    @GetMapping("/getBalance")
    public String getBalance(){
               return String.valueOf(userService.getBalance());
    }


}
