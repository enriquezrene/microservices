package com.udemy.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by rene on 18/01/16.
 */
@RestController
public class MyFirstEndpoint {

    @RequestMapping("/")
    public String sayHello() {
        return "hello";
    }
}
