package com.techelevator;

public class HelloWorld {

    public static void main(String[] args) {

        // This is a comment

        /*
            This is
            also
            a comment
            that I can put on multiple
            lines

         */

        System.out.println("Hello World!"); //Strings always have double quotes vs individual characters use single quotes ex. 'c'


        //To declare a variable:
        //1. First specify the type
        //2. Specify whatever name you want to call your variable (use camelCase)
        //3. You can assign a value right away or just put a semicolon at the end
        int numOfCats = 10;

        System.out.println(numOfCats);

        //When we assign a new value to a variable, we do not need to redeclare the type, it
        //will always remember what it was originally declared as (in this case, an int)
        numOfCats = 20;
        System.out.println(numOfCats);

        String name = "Chris";
        System.out.println(name);

        boolean isInstructor = true;
        System.out.println(isInstructor);

        double myDecimal = 2.5;
        System.out.println(myDecimal);

        char myLetter = 'c'; //characters require single quotes
        System.out.println(myLetter);

        String myLetter2 = "ca";
        System.out.println(myLetter2);

        double discount = .10;


        int amount = 5;
        int halfAmount = amount / 2;
        System.out.println(halfAmount);

        double halfAmount2 = amount / 2.0; //whatever datatype has the most precision on the right hand of the equals sign
                                            // will be the resulting data type assigned to the left hand side of the equals sign
        System.out.println(halfAmount2);

        double halfAmount3 = (double)amount / 2; //or we can cast it by using parentheses and then specifying the data type we want to cast to
        System.out.println(halfAmount3);

        int value = (int)2.5;  //explicit cast required when losing precision

        //implicit cast
        double dblValue = 2; //it is casting behind the scenes, but we don't need to be explicit because no precision is being lost


        String test = Character.toString('c');


        int sum = 2 + 3;
        System.out.println(sum);

        int result = 4 + 6 * 2;
        System.out.println(result);

        result = (4 + 6) * 2;
        System.out.println(result);

        String first = "Christopher";
        String lastInitial = "G";
        String fullName = first + " " + lastInitial;
        System.out.println(fullName);

    }

}
