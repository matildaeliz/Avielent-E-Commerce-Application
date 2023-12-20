package com.example.userservice.Response;



public class UserResponse {


    private String username;
    private String  password;

    public UserResponse(String username,String password){
        this.username = username;
        this.password = password;
    }
        public String getUsername(){
          return username;
         }
         public String getPassword(){
        return password;
    }
}
