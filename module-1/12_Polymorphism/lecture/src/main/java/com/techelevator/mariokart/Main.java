package com.techelevator.mariokart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("Begin Mario Kart");

        List<Racer> racers = new ArrayList<>();

        MediumCart mario = new MediumCart("Mario");
        MediumCart luigi = new MediumCart("Luigi");
        SmallCart princessPeach = new SmallCart("Princess Peach");
        SmallCart toad = new SmallCart("Toad");
        LargeCart wario = new LargeCart("Wario");
        LargeCart bowser = new LargeCart("Bowser");
        BlueShell blue = new BlueShell("Blue Shell");

        racers.add(mario);
        racers.add(luigi);
        racers.add(princessPeach);
        racers.add(toad);
        racers.add(wario);
        racers.add(bowser);

        int numOfLaps = 3;
        for (int i=1;i <= numOfLaps; i++ ){
            System.out.println("Round " + i);
            Collections.shuffle(racers);

            for (Racer racer : racers){
                System.out.println(racer.getName());
            }
        }

        System.out.println("WINNER: " + racers.get(0).getName());

    }

}
