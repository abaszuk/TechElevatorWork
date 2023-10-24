package com.techelevator;

public class Grandchild extends Child {

    private String grandChildProperty;

    public String getGrandChildProperty(){
        return grandChildProperty;
    }
    public void setGrandChildProperty(String prop){
        grandChildProperty = prop;
    }

    public void whoAmI(){
        System.out.println("This is the grandchild class");
    }
}
