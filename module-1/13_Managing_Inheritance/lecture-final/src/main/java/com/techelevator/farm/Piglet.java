package com.techelevator.farm;

import java.math.BigDecimal;

public class Piglet extends Pig{

   @Override
    public BigDecimal getPrice(){

       return new BigDecimal("10.90");
   }
}
