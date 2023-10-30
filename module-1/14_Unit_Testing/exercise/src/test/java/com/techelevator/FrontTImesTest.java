package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class FrontTImesTest {
    @Test
    public void test_front_times_Chocolate(){
        FrontTimes ftt = new FrontTimes();

        String result = ftt.generateString("Chocolate",2);

        Assert.assertEquals("ChoCho", result);
    }

    @Test
    public void test_front_times_abc(){
        FrontTimes ftt = new FrontTimes();

        String result = ftt.generateString("Abc",3);

        Assert.assertEquals("AbcAbcAbc", result);
    }


}
