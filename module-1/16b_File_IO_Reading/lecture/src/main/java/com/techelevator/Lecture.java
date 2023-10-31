package com.techelevator;

public class Lecture {

    public static void main(String[] args) {


        String name = "Jack";

        System.out.println("Before getting the length");

        //in the try block we are putting the code we think is at risk of throwing
        //an exception
        try {

            System.out.println("The length of my string is " + name.length());
            int result = Integer.parseInt("Two");
            System.out.println("Our converted int is " + result);

        }
        //if an exception does get thrown then it will fall down into our catch statments
        //searching for a catch that has the same type of exception as what got thrown
        //once it finds a match, it runs the code associated with that catch
        catch (NullPointerException ex){
            System.out.println("Something went wrong getting the length");
        } catch (NumberFormatException ex){
            System.out.println("Please enter a valid number");
        } catch (Exception ex){
            System.out.println("Something went wrong");
        } finally {
            System.out.println("This runs regardless of an exception");
        }

        System.out.println("After getting the length");

    }

    public void myMethod() throws Exception{

            if (true) {
                //Throw is like a return statement in that it will stop
                //the execution of this method and return immediately to wherever it was called from
                throw new Exception("Something went wrong");
            }

    }

}
