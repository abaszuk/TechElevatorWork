package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class MaxEnd3Test {

    @Test
    public void maxEnd3_123(){
        //Arrange
        MaxEnd3 me3 = new MaxEnd3();
        int[] params = {1,2,3};

        //Act
        int[] result = me3.makeArray(params);

        //Assert
        int[] expected = {3,3,3};
        Assert.assertArrayEquals(expected,result);

    }
}
