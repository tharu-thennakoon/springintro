package com.ijse.springintro.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  //rest API  controller define
public class HelloController {
    
    //API endpoint define
    @GetMapping("/hello")
    public String sayHello(){
        return "Hello Springboot";
    }

    @PostMapping("/hello")
    public String postRequest(){
        return "This is a POST request to Hello Endpoint";
    }

}
