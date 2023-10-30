package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class NonStartTest {
    @Test
    public void test_non_start_ello(){
        NonStart nst = new NonStart();

        String result = nst.getPartialString("Hello", "There");

        Assert.assertEquals("ellohere", result);
    }

    @Test
    public void test_non_start_null(){
        NonStart nst = new NonStart();

        String result = nst.getPartialString(null, null);

        Assert.assertEquals("", result);
    }

    @Test
    public void test_non_start_java(){
        NonStart nst = new NonStart();

        String result = nst.getPartialString("", "java");

        Assert.assertEquals("ava", result);
    }
    @Test
    public void test_non_start_hotl(){
        NonStart nst = new NonStart();

        String result = nst.getPartialString("shotl", "");

        Assert.assertEquals("hotl", result);
    }
}
