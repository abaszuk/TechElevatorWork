package com.techelevator;

public class Grandchild extends Child{

    private String grandchildProperty;

    public Grandchild(){

        //if parentProperty is private I would not have access
        //but making it protected lets all children see it
       //this.parentProperty = "Hair Color";
        setParentProperty("Hair Color");
    }

    public String getGrandchildProperty(){
        return grandchildProperty;
    }

    public void setGrandchildProperty(String prop){
        this.grandchildProperty = prop;
    }

    @Override
    public void whoAmI(){
        super.whoAmI();
        System.out.println("This is the grandchild class");
    }
}
