package com.techelevator.farm;

public class Tractor implements Farmable {

    //call this tractor and it makes a noise vroom
    public String getName(){
        return "Tractor";
    }

    public String getSound(){
        return "Vroom";
    }
}
