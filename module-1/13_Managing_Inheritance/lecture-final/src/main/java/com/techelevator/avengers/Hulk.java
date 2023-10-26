package com.techelevator.avengers;

public class Hulk extends Avenger{

    private final String NAME = "Incredible Hulk";

    public Hulk(){
        super("Incredible Hulk", "Super Strength");
    }

    public final void smash(){
        System.out.println("Hulk Smash!");
    }

}
