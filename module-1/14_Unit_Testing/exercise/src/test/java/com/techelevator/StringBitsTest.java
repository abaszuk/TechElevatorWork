package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class StringBitsTest {
    @Test
    public void test_string_bits_hello(){
        StringBits sbt = new StringBits();

        String result = sbt.getBits("Hello");

        Assert.assertEquals("Hlo", result);
    }
}
