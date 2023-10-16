package com.techelevator;

import java.util.Scanner;

public class Scratch {

    public static void main(String[] args) {

        // we are passing a "streaming service" to our scanner
        // so that we can read data from it.
        // System.in is the console
        Scanner inputScanner = new Scanner(System.in);

        System.out.println("What is your name?");

        //if we want to get input from the console
        // we can use .nextLine() which will read a string in
        // from the console.
        String name = inputScanner.nextLine();

        System.out.println("Hello, " + name);

        // What do we do when we want a number instead of a string?
        // We still import the string, but then convert

        System.out.println("Please enter a number:");
        String num1Str = inputScanner.nextLine();

        System.out.println("Please enter another number:");
        String num2Str = inputScanner.nextLine();

        //Now that we have the string values
        //we can use Integer to convert to the int data type
        //int num1 = Integer.parseInt(num1Str);
        //int num2 = Integer.parseInt(num2Str);

        double num1 = Double.parseDouble(num1Str);
        double num2 = Double.parseDouble(num2Str);

        double sum = num1 + num2;
        System.out.println("Our sum is " + sum);

        //when we check if two strings are equal, we have to use
        //.equals instead of == because it is stored as an object
        //instead of a primitive. Objects use .equals while primitives (int, double, boolean, char, etc)
        //can use ==
        if(num1Str.equals(num2Str)){
            System.out.println("The two numbers you entered are equal!");
        } else {
            System.out.println("The two numbers you entered are not equal!");
        }

        //If we are receiving a comma separated list or some other text that we want to break up,
        // we can use the .split method

        System.out.println("Please enter a comma separated list of groceries:");

        String groceries = inputScanner.nextLine();

        String[] groceryList = groceries.split(",");
        for(int i=0; i < groceryList.length; i++){
            System.out.println((i+1) + ".) " + groceryList[i]);
        }

    }
}
