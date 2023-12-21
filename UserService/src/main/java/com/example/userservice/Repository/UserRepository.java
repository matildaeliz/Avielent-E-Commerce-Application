package com.example.userservice.Repository;

import com.example.userservice.Entity.UserEntity;
import com.example.userservice.Response.UserResponse;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<UserEntity,String> {

    @Query("SELECT user.password FROM UserEntity user WHERE user.username =:username")
    String authorization(@Param("username") String username);

    @Query("SELECT user.username FROM UserEntity user  WHERE user.username =:username ")
    String findUserByUsername(@Param("username")String username);

    @Transactional
    @Modifying
    @Query("UPDATE UserEntity user SET user.password =:password WHERE user.username=:username")
    void updatePassword(@Param("username") String username, @Param("password") String password);
    @Transactional
    @Modifying
    @Query("UPDATE UserEntity user SET user.email =:email WHERE user.username=:username")
    void updateEmail(@Param("username")String username, @Param("email")String email);

    @Transactional
    @Modifying
    @Query("UPDATE UserEntity user SET user.balance =:balance WHERE user.username=:username")
    void updateBalance(@Param("username")String username, @Param("balance")int balance);

    @Query("SELECT user.balance FROM UserEntity user WHERE user.username =:username")
    int getBalance(@Param("username")String username);
}
