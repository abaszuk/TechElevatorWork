package com.techelevator.avengers;

public class IronMan extends Avenger implements Flyable {

    private int durability;

    public IronMan(){
        super("Iron Man", "Super suit, billionaire, philanthropist");

    }

    @Override
    public void fly() {
        System.out.println("Iron Man is flying");
    }
}
