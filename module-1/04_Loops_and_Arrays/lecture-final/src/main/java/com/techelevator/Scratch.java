package com.techelevator;

public class Scratch {



    public static void main(String[] args) {

        //we used to have to declare variables one at a time
        int num1 = 1;
        int num2 = 3;
        int num3 = 10;

        //what if we want to keep them all grouped together in a collection?

        //first way to declare an array, we indicate the type and size of the array
        //then we can add values into it
        int arraySize = 5;
        int[] myNumArray = new int[arraySize];

        //anytime we want to access the first element, it is always index 0

        //how we write to a specific index
        myNumArray[0] = 1;

        //how we read from an index
        System.out.println( myNumArray[0] );

        //we can read the length from the array
        int length = myNumArray.length;

        //if we want the last element of an array
        int lastElement = myNumArray[length-1];

        //if I want assign 3 to the second place in my array:
        myNumArray[1] = 3;

        //if * want to assign 10 to the third place in my array:
        myNumArray[2] = 10;
        myNumArray[2] = 11;
        myNumArray[2] = 12;

        //if we try to access an index that does not exist we get an out of bounds error
        //myNumArray[5] = 10;

        System.out.println(myNumArray[0]);
        System.out.println(myNumArray[1]);
        System.out.println(myNumArray[2]);
        System.out.println("***********");

        //There is a second way to declare an array, if we already know the values
        int[] myNumArray2 = {1,3,10};

        System.out.println(myNumArray2[0]);
        System.out.println(myNumArray2[1]);
        System.out.println(myNumArray2[2]);


        //We can make arrays of any data type
        String[] names = new String[5];
        boolean[] boolArray = {true, false, true, true};
        double[] doubleArray = new double[4];
        int[] intArray = {1,2,3,4};
        Scratch[] scractArray = new Scratch[10];

        System.out.println("*************");

        //While loop
        //the loop will continue to execute as long as the condition is true and it has not hit a break
        //if I want to print out each value in myNumArray:
        int counter = 0;
        while(counter < myNumArray.length) {
            System.out.println(myNumArray[counter]);

            //All three of the lines below are doing the exact same thing with different syntax
            //counter = counter + 1;
            //counter += 1;
            counter ++;

            //once I reach a break, the loop will stop
            //break;
        }

        System.out.println("***********");

        //For Loop:
        //Step 1: indicate the starting index
        //Step 2: indicate the condition to check each time the loop runs
        //Step 3: indicate how the index changes after each time the loop runs
        for(int i = 0; i < myNumArray.length; i++) {
            System.out.println(myNumArray[i]);
        }


    }
}
