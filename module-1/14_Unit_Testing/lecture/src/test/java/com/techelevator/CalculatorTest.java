package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

    //We always want to use the @Test to indicate if
    //the method itself is a tes JUnit should run
    //the vast majority of the time the tes will be void return type
    @Test
    public void test_add_with_positive_numbers(){
        //Arrange - instantiate the class that has the method
        //          you want to test, along with any other variables
        //          you may want
        Calculator calc = new Calculator();

        //Act - call the specific method we want to test
        //      and store it in a result variable
        int result = calc.add(2,3);

        //Assert
        Assert.assertEquals(5,result);

    }

    @Test
    public void test_add_with_negative_numbers(){
        //Arrange - instantiate the class that has the method
        //          you want to test, along with any other variables
        //          you may want
        Calculator calc = new Calculator();

        //Act - call the specific method we want to test
        //      and store it in a result variable
        int result = calc.add(-2,-3);

        //Assert
        Assert.assertEquals(-5,result);

    }

    @Test
    public void test_subtract_with_positive_result(){

        //Arrange
        Calculator calc = new Calculator();

        //act
        int result = calc.subtract(3,2);

        //assert
        Assert.assertEquals(1,result);
    }

    @Test
    public void test_subtract_with_negative_result(){

        //Arrange
        Calculator calc = new Calculator();

        //act
        int result = calc.subtract(2,3);

        //assert
        Assert.assertEquals(-1,result);
    }

    @Test
    public void test_multiply_with_positive_result(){

        //Arrange
        Calculator calc = new Calculator();

        //act
        int result = calc.multiply(2,3);

        //assert
        Assert.assertEquals(6,result);
    }

    @Test
    public void test_multiply_with_negative_result(){

        //Arrange
        Calculator calc = new Calculator();

        //act
        int result = calc.multiply(2,-3);

        //assert
        Assert.assertEquals(-6,result);
    }

    @Test
    public void test_remainder_of_2(){
        //Arrange
        Calculator calc = new Calculator();

        //Act
        int result = calc.remainder(10,8);

        //Assert
        Assert.assertEquals(2,result);
    }

}
