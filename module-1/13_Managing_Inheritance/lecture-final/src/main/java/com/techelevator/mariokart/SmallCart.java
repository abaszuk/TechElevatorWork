package com.techelevator.mariokart;

public class SmallCart extends Racer{

    public SmallCart(String name) {
        super(name, Racer.SMALL_CART);
    }

    public int getMaxSpeed(){
        return 125;
    }

    //I could program small carts to be fastest

}
