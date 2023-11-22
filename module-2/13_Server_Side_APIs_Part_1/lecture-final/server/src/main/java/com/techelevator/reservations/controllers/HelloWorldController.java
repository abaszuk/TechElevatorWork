package com.techelevator.reservations.controllers;

import com.techelevator.reservations.model.SimpleModel;
import org.springframework.web.bind.annotation.*;

/*
@RestController tells Spring that anytime we receive an HTTP request,
to check this class and see if any of the endpoints match the request.
If so - it will run that specific method
 */
@RestController
public class HelloWorldController {

    /*
        @RequestMapping - specifies the method as an API endpoint,
        indicating the path and the verb that should match the request
     */
    //Ex: localhost:8080/hello/Bob/Smith?holiday=Thanksgiving
    @RequestMapping(path="/hello/{name}/{lastName}", method= RequestMethod.GET)
    public String sayHello(@PathVariable String name,
                           @PathVariable String lastName,
                           @RequestParam(defaultValue = "Holidays") String holiday,
                           @RequestParam(required=false) Integer value){
        return "Hello "+name+"! Happy " + holiday;
    }

    @RequestMapping(path="/hello", method= RequestMethod.POST)
    public String sayHelloPost(@RequestBody SimpleModel model){
        return "String val is " + model.getStrValue()
                + " and int val is " + model.getIntValue();
    }

    @RequestMapping(path="/jsonExample", method=RequestMethod.GET)
    public SimpleModel getSimpleModel(){
        SimpleModel m = new SimpleModel();
        m.setIntValue(10);
        m.setStrValue("Happy Thanksgiving");
        return m;
    }
}
