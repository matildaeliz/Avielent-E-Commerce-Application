package com.example.userservice.Service;

import org.springframework.http.ResponseEntity;

public interface LoginInterface {

    ResponseEntity authorization(String username, String password);
}
