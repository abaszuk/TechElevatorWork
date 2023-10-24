package com.techelevator;

//1. to inherit from a class use the extends keyword
//2. each class can only extend one other class
//meaning there is no multiple inheritance
//3. we can have another class extend child
// which would then inherit all of parent and child
public class Child extends Parent{

    private String childProperty;

    public String getChildProperty(){
        return childProperty;
    }

    public void setChildProperty(String prop){
        childProperty = prop;
    }

    public void whoAmI(){
        System.out.println("This is the child class");
    }
}
