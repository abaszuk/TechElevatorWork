package com.techelevator;

public class House {

    //DATA
    private String color;

    private boolean hasOptionalHalfBath;

    private String trimStyle;

    //BEHAVIOR
    public void openDoor(){
        System.out.println("Door is now open");
    }

    public String getColor(){
        return color;
    }

    public void setColor(String color){
        this.color = color;
    }

}
