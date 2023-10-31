package com.techelevator;

import com.techelevator.exceptions.OverdraftException;

public class Lecture {

    public static void main(String[] args) {


        String name = "Jack";


        System.out.println("Before getting the length");

        //in the try block we are putting the code that we think is at risk of throwing
        //an exception.
        try {

            System.out.println("The length of my string is " + name.length());
           // int result = Integer.parseInt("Two");
          //  System.out.println("Our converted int is " + result);

           myMethod();

        }
        //if an exception does get thrown then it will fall down into out catch statements
        //searching for a catch that has the same type of exception as what got thrown.
        //once it finds a match, it runs the code associated with that catch
        catch(NullPointerException ex){
            System.out.println("Something went wrong getting the length: ");
        }
        catch(OverdraftException ex){
            System.out.println("Something went wrong!!!");
        }
        finally{
            System.out.println("This runs regardless of an exception");
        }

        System.out.println("After getting the length");
    }

    public static void myMethod() throws OverdraftException {
        System.out.println("Starting my method");


      //  try {
            if (true) {
                //throw is essentially like a return statement in that it will stop
                //the execution of this method and return immediately to wherever it was called from
                throw new OverdraftException("Something went wrong", 0);
            }

            //other code


      //  } catch(Exception ex){
      //      System.out.println("Something went wrong in my method");
      //  }

        //other code

    }

}
