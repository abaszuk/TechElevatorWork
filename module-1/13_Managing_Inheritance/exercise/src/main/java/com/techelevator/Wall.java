package com.techelevator;

//abstract prevents Wall from being directly instantiated
public abstract class Wall {

    private String name;
    private String color;

    public Wall(String name, String color){
        this.name = name;
        this.color = color;
    }

    //When we provide getters but no setters that makes
    //this property read only because there is no option to set.
    public String getName(){
        return name;
    }
    public String getColor(){
        return color;
    }

    //abstract means that we have to override it
    public abstract int getArea();
}
