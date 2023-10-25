package com.techelevator.farm;

public class Tractor implements Audible {

    //call this tracker and it makes a noise vroom
    private String sound = "vroom";
    private String name = "Tractor";
    public String getSound(){
        return sound;
    }

    public String getName(){
        return name;
    }
}
