package com.techelevator;

public class Scratch {
    public static void main(String[] args) {

        //first way to declare an array, we indicate the type(int) and size[3] of the array
        //then we can add values into it
        int[] myNumArray = new int [3];

        //anytime we want to access the first element it is always index 0

        //how we write to a specific index
        myNumArray[0] = 1;

        //how we read from an index
        System.out.println(myNumArray[0]);

        //we can read the length from the array
        int length = myNumArray.length;

        //if we want the last element of an array
        int lastElement = myNumArray[length - 1];

        //if i want to assign 3 to the second place in my array:
        myNumArray[1] = 3;

        // if i want to assign 10 to the third place in my array
        myNumArray[2] = 10;

        System.out.println(myNumArray[0]);
        System.out.println(myNumArray[1]);
        System.out.println(myNumArray[2]);

        //there is a second way to declare an array if we already know the values
        int[] myNumArray2 = {1,3,10};


        //we can make arrays of any data type
        String[] names = new String[5];
        boolean[] bollArray = {true,false,true,true};

        //while loop
        int counter = 0;
        while(counter < myNumArray.length){
            System.out.println(counter);

            //all three do the same thing
            //counter = counter + 1;
            //counter += 1;
            counter++;

        }
        //for loop
        //step 1 indicate the starting index
        //step 2 indicate the condition to check each time the loop runs
        //step 3 indicate how the index changes after each time the loop runs
        for(int i = 0; i < myNumArray.length; i++){
            System.out.println(myNumArray[i]);
        }




    }
}
