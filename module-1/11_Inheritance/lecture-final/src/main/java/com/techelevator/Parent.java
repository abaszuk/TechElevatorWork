package com.techelevator;

public class Parent {

    private String parentProperty;

    public String getParentProperty(){
        return parentProperty;
    }

    public void setParentProperty(String parentProperty){
        this.parentProperty = parentProperty;
    }


    public void whoAmI(){
        System.out.println("This is the parent class");
    }
}
