package com.techelevator;

//1. To inherit from a class use the extends keyword
//2. Each class can only extend one other class
//meaning there is no multiple inheritance
// 3. We can have another class extend child,
//  which would then inherit all of Parent and Child
public class Child extends Parent{

    private String childProperty;

    public String getChildProperty(){
        return childProperty;
    }

    public void setChildProperty(String prop){
        childProperty = prop;
    }

    @Override
    public void whoAmI(){
        super.whoAmI();
        System.out.println("This is the child class");
    }
}
