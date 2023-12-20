package com.example.userservice.Service;

import com.example.userservice.Entity.UserEntity;
import com.example.userservice.Repository.UserRepository;
import com.example.userservice.Response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;


@Service
@CrossOrigin(origins = "http://localhost:8080")
public class UserService implements LoginInterface{
    @Autowired
    private UserRepository userRepository;

     public ResponseEntity addUser(UserResponse userResponse){


         if(findUser(userResponse.getUsername())){
             return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
         }else {
             userRepository.save(new UserEntity(userResponse.getUsername(),userResponse.getPassword()));
             return ResponseEntity.status(HttpStatus.OK).build();
         }
      }


    public ResponseEntity authorization(String username, String password){
        if(userRepository.authorization(username) == null || !userRepository.authorization(username).equals(password)){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }else {
            return  ResponseEntity.ok("Logged in");
        }
    }


    public  boolean findUser(String username){
        if (userRepository.findUserByUsername(username) !=null){
            return true;
        }else {
            return false;
        }
    }

}
