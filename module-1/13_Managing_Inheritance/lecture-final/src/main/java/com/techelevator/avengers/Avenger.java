package com.techelevator.avengers;

public class Avenger {

    //class variables
    private String name;
    private String skill;

    public Avenger(String name, String skill){
        this.name = name;
        this.skill = skill;
    }


    //getters and setters
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getSkill(){
        return skill;
    }

    public void setSkill(String skill){
        this.skill = skill;
    }

    //behavior
    public void assemble(){
        System.out.println(name+" attacks with " + skill + "!");
    }


}
