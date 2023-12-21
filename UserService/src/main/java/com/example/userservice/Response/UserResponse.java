package com.example.userservice.Response;



public class UserResponse {


    private String username;
    private String  password;

    private String email;
    private int balance;

    public UserResponse(String username,String password,String email, int balance){
        this.username = username;
        this.password = password;
        this.email= email;
        this.balance = balance;

    }
        public String getUsername(){
          return username;
         }
         public String getPassword(){
        return password;
    }
            public  String getEmail(){
        return email;
}
    public  int getBalance(){
        return balance;
    }

}
