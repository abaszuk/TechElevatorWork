package com.techelevator;

import java.util.Scanner;

public class Scratch {

    public static void main(String[] args) {

        //we are passing a streaming service to our scanner
        //so we can read data from it
        //System.in is the console
        Scanner inputScanner = new Scanner(System.in);

        System.out.println("What is your name?");

        //if we want to get input from the console
        //we can use .nextLine() which will read a string in from the console
        String name = inputScanner.nextLine();

        System.out.println("Hello, " + name);

        //What do we do when we want a number instead of a string?
        //we stil import the string but then we convert


        System.out.println("Please enter a number: ");
        String num1Str = inputScanner.nextLine();

        System.out.println("Please enter another number: ");
        String num2Str = inputScanner.nextLine();

        //Now that we have the string values
        //We can use integer to convert to the int data type
        //if you want a double change Integer/parseInt to Double/parseDouble
        int num1 = Integer.parseInt(num1Str);
        int num2 = Integer.parseInt(num2Str);

        int sum = num1 + num2;
        System.out.println("Our sum is " + sum);

        //when we check if two strings are equal, we have to use
        //.equals instead of == because it is stored as an object
        //instead of a primitive. Objects use .equals while primitives use == (int, double, boolean...)
        if (num1Str.equals(num2Str)){
            System.out.println("the two numbers you entered are equal");
        } else {
            System.out.println("the two numbers you entered are not equal");
        }

        //if we are receiving a comma separated list or some other text that we want to break up
        //we can use the .split method

        System.out.println("Please enter a comma separated list of groceries");

        String groceries = inputScanner.nextLine();

        String[] groceryList = groceries.split(",");
        for (int i = 0; i < groceryList.length; i++){
            System.out.println(i + ".) " + groceryList[i]);
        }



    }
}
