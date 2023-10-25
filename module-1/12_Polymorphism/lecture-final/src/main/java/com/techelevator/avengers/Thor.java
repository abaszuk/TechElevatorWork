package com.techelevator.avengers;

import java.io.Serializable;

public class Thor extends Avenger implements Flyable, Hammerable {

    public Thor(){
        super("Thor", "Wield The Mighty Hammer");
    }

    public void fly(){
        System.out.println("Thor is flying");
    }

    public void hammer(){
        System.out.println("Thor is hammering");
    }
}
