package com.techelevator;

public class FruitTree {

    private String typeOfFruit;

    private int piecesOfFruitLeft;

    public String getTypeOfFruit(){
        return typeOfFruit;
    }

    public int getPiecesOfFruitLeft(){
        return piecesOfFruitLeft;
    }

    //constructor
    public FruitTree(String typeOfFruit, int startingPiecesOfFruit){
        this.typeOfFruit = typeOfFruit;
        this.piecesOfFruitLeft = startingPiecesOfFruit;
    }

    //method
    public boolean pickFruit(int numberOfPiecesToRemove){
        if (piecesOfFruitLeft >= numberOfPiecesToRemove){
            piecesOfFruitLeft -= numberOfPiecesToRemove;
            return true;
        }
        return false;
    }

}
