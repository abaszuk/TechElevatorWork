package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Budget {

    public static void main(String[] args) {

        //First we want to get the location of our file
        String fileName = "C:\\Users\\Student\\instructor_repos\\instructor-code\\module-1\\16b_File_IO_Reading\\lecture-final\\transactions.txt";

        //Next we want to create a File object from our path
        File file = new File(fileName);

        //The scanner will open the file to read its contents
        //We can put it in a try with resources so that it's automatically
        //opened and closed appropriately
        try(Scanner fileReader = new Scanner(file)) {

            Map<String, Integer> budget = new HashMap<>();

            //The Scanner will read the file one line at a time
            //so first check if the file still has lines to read
            while(fileReader.hasNextLine()){

                //read in the line of the file
                String line = fileReader.nextLine();

                //take the line of text, and split it on the space
                String[] lineParts = line.split(" ");
                String category = lineParts[0].toUpperCase();
                Integer price = Integer.parseInt(lineParts[1]);

                if(budget.containsKey(category)){

                    Integer originalValue = budget.get(category);
                    Integer newValue = originalValue + price;
                    budget.put(category, newValue);

                } else {
                    budget.put(category, price);
                }

            }

            System.out.println(budget);

        } catch(FileNotFoundException ex){
            System.out.println("File was not available");
        } /* We don't need the finally because the try with resources will automatically close
        //it for us
        finally{
            fileReader.close();
        } */
    }

}
