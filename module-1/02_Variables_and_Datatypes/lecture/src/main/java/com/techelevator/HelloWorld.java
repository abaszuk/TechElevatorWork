package com.techelevator;

public class HelloWorld {

    public static void main(String[] args) {

        // This is a comment

        /*
        THis is
        also
        a comment
        that I can put on multiple
        lines

         */

        System.out.println("Hello World"); //Strings always have double quotes vs individual characters use single quotes ex. 'c'


        //to declare a variable:
        // 1. First specify the type
        // 2. specify whatever name you want to call your variable
        // 3. you can assign a value right away or just put a semicolon at the end
        int numOfCats = 10;

        System.out.println(numOfCats);

        //When we assign a new value to a variable we do not need to redeclare the type
        // it will always remember what it was originally declared as (in this case, an int)
        numOfCats = 20;
        System.out.println(numOfCats);

        String name = "alex";
        System.out.println(name);

        boolean isInstructor = true;
        System.out.println(isInstructor);

        char myLetter = 'a';
        System.out.println(myLetter);

        double discount = .10;
        System.out.println(discount);

        int amount = 5;
        int halfAmount = amount / 2; //equals 2 because int cannot hold decimals
        System.out.println(halfAmount);

        double halfAmount2 = amount / 2.0;  //whatever datatype has the most precision on the right hand of the equals sign
                                            //will be the resulting data type assigned to the left hand side of the equals sign
        System.out.println(halfAmount2);

        int value = (int)2.5; //explicit cast required when losing precision


    }


}
