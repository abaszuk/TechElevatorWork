package com.techelevator.mariokart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("Begin Mario Kart");

        //List is an interface
        //ArrayList is a class that implements it
        List<Raceable> racers = new ArrayList<>();

        //Racer r = new Racer("","Gigantic");

        Racer mario = new MediumCart("Mario");
        MediumCart luigi = new MediumCart("Luigi");
        SmallCart princessPeach = new SmallCart("Princess Peach");
        SmallCart toad = new SmallCart("Toad");
        LargeCart wario = new LargeCart("Wario");
        LargeCart bowser = new LargeCart("Bowser");
        BlueShell blue = new BlueShell("Blue Shell");


        mario.getMaxSpeed();
        wario.getMaxSpeed();
        princessPeach.getMaxSpeed();

        racers.add(mario);
        racers.add(blue);
        racers.add(luigi);
        racers.add(princessPeach);
        racers.add(toad);
        racers.add(wario);
        racers.add(bowser);


        int numOfLaps = 3;

        for(int i=1; i <= numOfLaps; i++ ){
            System.out.println("Round " + i);

            Collections.shuffle(racers);

            //If the blue shell is in second place
            //then that means the first place racer
            //should be blown up
            if(racers.get(1) instanceof BlueShell){
                //get the racer who is in first place
                Raceable racer = racers.get(0);

                //remove that racer from first place
                //and destroy the blue shell
                racers.remove(0);
                racers.remove(1);

                System.out.println(racer.getName() + " was hit by a blue shell!");

                //put the racer in last place
                racers.add(racer);
            }

            //For each racer of data type Racer
            //in the list racers, print out their name
            for(Raceable racer : racers) {
               // if(! (racer instanceof BlueShell)) {
                    System.out.println(racer.getName());
               // }
            }
        }

        System.out.println("WINNER: " + racers.get(0).getName());

    }

}
