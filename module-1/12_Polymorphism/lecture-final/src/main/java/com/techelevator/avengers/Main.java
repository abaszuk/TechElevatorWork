package com.techelevator.avengers;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("Avengers Start");

        List<Avenger> avengers = new ArrayList<>();

        IronMan tony = new IronMan();
        Thor thor = new Thor();
        BlackWidow blackWidow = new BlackWidow();
        Hulk hulk = new Hulk();

        avengers.add(tony);
        avengers.add(thor);
        avengers.add(blackWidow);
        avengers.add(hulk);

        //for each avenger of data type Avenger
        //that we find in our avengers list
        //tell each one to assemble
        for(Avenger avenger : avengers){
            avenger.assemble();

            if(avenger instanceof Hulk){
                Hulk h = (Hulk)avenger;
                //avenger.smash();
                h.smash();
            }

            if(avenger instanceof Flyable){
                Flyable flier = (Flyable)avenger;
                flier.fly();
            }
        }

        //What we want to avoid
       /* tony.assemble();
        thor.assemble();
        blackWidow.assemble();
        hulk.assemble();
*/

    }
}
