package com.example.example4.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/hello")
    public String hii(){
        return "hello I am working";
    }

}
