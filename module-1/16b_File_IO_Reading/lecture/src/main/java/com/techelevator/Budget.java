package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Budget {

    public static void main(String[] args) {
        //First we want to get the location of our file
        String filename = "C:\\Users\\Student\\Workspace\\alex-baszuk-student-code\\module-1\\16b_File_IO_Reading\\lecture\\transactions.txt";

        //next we want to create a file object from our path
        File file = new File(filename);

        try (Scanner fileReader = new Scanner(file)){

            Map<String, Integer> budget = new HashMap<>();

            //The scanner will read the file one line at a time
            //so first check if the file still has lines to read
            while(fileReader.hasNext()) {
                //this will read in the line of the file
                String line = fileReader.nextLine();
                //take the line of text and split it on the space
                String[] lineParts = line.split(" ");
                String category = lineParts[0].toUpperCase();
                Integer price = Integer.parseInt(lineParts[1]);

                if (budget.containsKey(category)){
                    Integer originalValue = budget.get(category);
                    Integer newValue = originalValue + price;
                    budget.put(category,newValue);

                }else {
                    budget.put(category,price);
                }
            }

            System.out.println(budget);
        } catch (FileNotFoundException ex){
            System.out.println("File was mpt available");
        } //finally {
            //fileReader.close();
        }
    }

