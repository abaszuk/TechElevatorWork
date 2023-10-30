package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class Less20Test {
    @Test
    public void test_less_20_18(){
        Less20 l2t = new Less20();

        boolean result = l2t.isLessThanMultipleOf20(18);

        Assert.assertEquals(true,result);
    }
    @Test
    public void test_less_20_20(){
        Less20 l2t = new Less20();

        boolean result = l2t.isLessThanMultipleOf20(20);

        Assert.assertEquals(false,result);
    }
}
