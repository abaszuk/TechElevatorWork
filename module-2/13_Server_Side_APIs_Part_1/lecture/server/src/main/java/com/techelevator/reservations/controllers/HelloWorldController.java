package com.techelevator.reservations.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    //@requestMapping - specifies the method as an API endpoint,
    //indicating the path and the verb that should match the request
@RequestMapping(path = "/hello/{name}", method = RequestMethod.GET)
    public String sayHello(@PathVariable String name){
        return "hello "+name;

    }

}
