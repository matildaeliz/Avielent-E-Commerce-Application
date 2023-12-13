package com.example.frontend.Controller;

import org.springframework.web.bind.annotation.GetMapping;

public class FrontendController {
    @GetMapping("")
    public String index() {
        return "index";
    }
}
