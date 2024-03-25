package com.in28minutes.unittesting.unittesting.controller;

import com.in28minutes.unittesting.unittesting.model.Item;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {
    @GetMapping("/dummy-item")
    public Item dummyItem(){
        return new Item(1, "Ball", 10, 100);
    }

}

/*
Unit Testing ==> Testing only a controller in class. Eg: the HelloWorldController here
Integration Testing ==> Testing all the controllers in a class.
*/

