package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class TellerMachineTests {

    @Test
    public void test_balance_calculation() {
        //Arrange
        TellerMachine teller = new TellerMachine("Umbrella Corp", 100, 25);

        //Act
        int result = teller.getBalance();

        //Assert
        Assert.assertEquals(75, result);
    }

    @Test
    public void test_card_number(){
        //Arrange
        TellerMachine teller = new TellerMachine("Umbrella Corp", 100, 25);

        //Act
        boolean result = teller.isCardNumberValid("5111111111111111");

        //Assert
        Assert.assertEquals(true, result);
    }
}
