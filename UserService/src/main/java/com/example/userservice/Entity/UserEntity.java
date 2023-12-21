package com.example.userservice.Entity;
import jakarta.persistence.*;

@Entity
@Table(name="userinfo")
public class UserEntity {
    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private double balance;

    public UserEntity(String username,String password){
        this.username=username;
        this.password=password;
    }
    public UserEntity(){

    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public int getId(){
        return id;
    }
    public int getBalance(){
        return balance;
    }
    public void setBalance(double balance){
        this.balance=balance;
    }

}
