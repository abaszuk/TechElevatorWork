package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTests {

    //We always want to use the @Test to indicate if
    //the method itself is a test JUnit should run.
    //The vast majority of the time the tests will be void for return type
    @Test
    public void test_add_with_positive_numbers(){

        //Arrange - instantiante the class that has the method
        //         you want to test, along with any other variables
        //         you may want
        Calculator calc = new Calculator();

        //Act - call the specific method we want to test
        //      and store it in a result variable
        int result = calc.add(2,3);

        //Assert
        Assert.assertEquals(5, result);
    }

    @Test
    public void test_add_with_negative_numbers(){

        //Arrange - instantiante the class that has the method
        //         you want to test, along with any other variables
        //         you may want
        Calculator calc = new Calculator();

        //Act - call the specific method we want to test
        //      and store it in a result variable
        int result = calc.add(-2,-3);

        //Assert
        Assert.assertEquals(-5, result);
    }

    @Test
    public void test_subtract_with_positive_result(){

        //Arrange
        Calculator calc = new Calculator();

        //Act
        int result = calc.subtract(3,2);

        //Assert
        Assert.assertEquals(1, result);

    }

    @Test
    public void test_subtract_with_negative_result(){

        //Arrange
        Calculator calc = new Calculator();

        //Act
        int result = calc.subtract(2,3);

        //Assert
        Assert.assertEquals(-1, result);

    }

    @Test
    public void test_multiply_with_positive_numbers(){

        //Arrange
        Calculator calc = new Calculator();

        //Act
        int result = calc.multiply(10,10);

        //Assert
        Assert.assertEquals(100, result);
    }

    @Test
    public void test_multiply_with_negative_numbers(){

        //Arrange
        Calculator calc = new Calculator();

        //Act
        int result = calc.multiply(-10,10);

        //Assert
        Assert.assertEquals(-100, result);
    }

    @Test
    public void test_multiply_with_zero(){

        //Arrange
        Calculator calc = new Calculator();

        //Act
        int result = calc.multiply(0,10);

        //Assert
        Assert.assertEquals(0, result);
    }

    @Test
    public void test_remainder_of_2(){

        //Arrange
        Calculator calc = new Calculator();

        //Act
        int result = calc.remainder(10, 8);


        if(result == 0 ){
            Assert.fail("We should get back some sort of remainder");
        }

        //Assert
        Assert.assertEquals(2, result);


    }

    @Test
    public void test_remainder_of_0(){

        //Arrange
        Calculator calc = new Calculator();

        //Act
        int result = calc.remainder(10, 10);


        //Assert
        Assert.assertEquals(0, result);


    }

    @Test
    public void test_divide(){

        //Arrange
        Calculator calc = new Calculator();

        //Act
        int result = calc.divide(10, 5);


        //Assert
        Assert.assertEquals(2, result);


    }

}
