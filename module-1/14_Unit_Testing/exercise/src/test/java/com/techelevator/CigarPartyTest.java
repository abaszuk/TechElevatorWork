package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class CigarPartyTest {

    @Test
    public void test_have_party_30_false(){
        //Arrange
        CigarParty cpt = new CigarParty();

        //Act
        boolean result = cpt.haveParty(30, false);

        //Assert
        Assert.assertEquals(false, result);

    }

}
