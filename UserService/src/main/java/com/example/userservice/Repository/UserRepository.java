package com.example.userservice.Repository;

import com.example.userservice.Entity.UserEntity;
import com.example.userservice.Response.UserResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,String> {

    @Query("SELECT user.password FROM UserEntity user WHERE user.username =:username")
    String authorization(@Param("username") String username);

    @Query("SELECT user.username FROM UserEntity user  WHERE user.username =:username ")
    String findUserByUsername(@Param("username")String username);
}
