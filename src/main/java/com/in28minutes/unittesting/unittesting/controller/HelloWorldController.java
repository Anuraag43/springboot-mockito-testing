package com.in28minutes.unittesting.unittesting.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @GetMapping("/hello-world")
    public String helloWorld(){
        return "Hello-World";
    }
}

/*
Unit Testing ==> Testing only a controller in class. Eg: the HelloWorldController here
Integration Testing ==> Testing all the controllers in a class.
*/

