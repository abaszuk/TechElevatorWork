package com.techelevator.mariokart;


//An abstract class is a blend of both classes
//and interfaces. Like a class, it can provide functionality
//that is already written and can be inherited.
//Like an interface it can require functionality to be provided
//from a class that inherits from it
public abstract class Racer implements Raceable{

    public static final String SMALL_CART = "S";
    public static final String MEDIUM_CART= "M";
    public static final String LARGE_CART="L";

    private String name;
    private String size;

    public Racer(String name, String size){
        this.name = name;
        this.size = size;
    }

    public String getName(){
        return name;
    }

    //If we have an abstract method in a class
    //then that forces the class itself to be abstract
    public abstract int getMaxSpeed();

}
