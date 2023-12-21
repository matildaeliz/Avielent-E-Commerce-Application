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
    private String email;
    @Column
    private int balance;

    public UserEntity(String username,String password,String email){
        this.username=username;
        this.password=password;
        this.email=email;
        this.balance = 0;
    }
    public UserEntity(){

    }

}
