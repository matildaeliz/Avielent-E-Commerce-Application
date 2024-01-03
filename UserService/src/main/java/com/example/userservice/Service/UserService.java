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

   private String username ;

     public ResponseEntity addUser(UserResponse userResponse){


         if(findUser(userResponse.getUsername())){
             return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
         }else {
             userRepository.save(new UserEntity(userResponse.getUsername(),userResponse.getPassword(), userResponse.getEmail()));
             return ResponseEntity.status(HttpStatus.OK).build();
         }
      }


    public ResponseEntity authorization(String username, String password){
        if(userRepository.authorization(username) == null || !userRepository.authorization(username).equals(password)){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }else {
            this.username = username;

            return  ResponseEntity.ok("Logged in");
        }
    }
    public ResponseEntity changePassword(String password){
         userRepository.updatePassword(this.username,password);
         return ResponseEntity.ok("Password changed");
    }

    public ResponseEntity changeEmail(String email){
        userRepository.updateEmail(this.username,email);
        return ResponseEntity.ok("Email changed");
    }

    public  ResponseEntity updateBalance(int balance){
         try{
             {
                 int newbalance = userRepository.getBalance(this.username) + balance;
                 userRepository.updateBalance(this.username,newbalance);
                 return ResponseEntity.ok("Balance Updated");
             }
         }catch (NumberFormatException exception){
             return  ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
         }

    }

    public String getUsername(){
         return this.username;
    }

    public int getBalance(){
         return userRepository.getBalance(this.username);
    }

    public  boolean findUser(String username){
        if (userRepository.findUserByUsername(username) !=null){
            return true;
        }else {
            return false;
        }
    }

}
