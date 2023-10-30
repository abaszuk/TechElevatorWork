package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class Lucky13Test {
    @Test
    public void test_lucky_13_024(){
        Lucky13 l13 = new Lucky13();
        int[] params = {0,2,4};

        boolean result = l13.getLucky(params);

        Assert.assertEquals(true, result);

    }
    @Test
    public void test_lucky_13_123(){
        Lucky13 l13 = new Lucky13();
        int[] params = {1,2,3};

        boolean result = l13.getLucky(params);

        Assert.assertEquals(false, result);

    }
}
