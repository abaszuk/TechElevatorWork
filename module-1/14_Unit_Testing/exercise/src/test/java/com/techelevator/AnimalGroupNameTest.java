package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class AnimalGroupNameTest {
    @Test
    public void test_get_herd_giraffe(){
        //Arrange
        AnimalGroupName ang = new AnimalGroupName();

        //Act
        String result = ang.getHerd("giraffe");

        //Assert
        Assert.assertEquals("Tower", result);
    }

    @Test
    public void test_get_herd_empty(){
        //Arrange
        AnimalGroupName ang = new AnimalGroupName();

        //Act
        String result = ang.getHerd("");

        //Assert
        Assert.assertEquals("unknown", result);
    }

}
