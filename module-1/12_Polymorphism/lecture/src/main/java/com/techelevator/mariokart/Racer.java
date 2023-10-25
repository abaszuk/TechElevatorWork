package com.techelevator.mariokart;

public class Racer {

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



}
