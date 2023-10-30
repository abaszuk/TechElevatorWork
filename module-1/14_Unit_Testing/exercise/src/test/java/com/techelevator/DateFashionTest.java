package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class DateFashionTest {
    @Test
    public void test_date_fashion_5_10(){
        //Arrange
        DateFashion dft = new DateFashion();

        //Act
        int result = dft.getATable(5,10);

        //Assert
        Assert.assertEquals(2,result);
    }

    @Test
    public void test_date_fashion_5_2(){
        //Arrange
        DateFashion dft = new DateFashion();

        //Act
        int result = dft.getATable(5,2);

        //Assert
        Assert.assertEquals(0,result);
    }


}
