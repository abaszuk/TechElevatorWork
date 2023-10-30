package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class SamFirstLastTest {
    @Test
    public void test_same_first_last_123(){
        SameFirstLast sfl = new SameFirstLast();
        int[] params = {1,2,3};

        boolean result = sfl.isItTheSame(params);

        Assert.assertEquals(false,result);
    }
}
