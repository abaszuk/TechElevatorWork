package com.techelevator;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class FindAndReplace {

    // Use this scanner for all user input. Don't create additional Scanners with System.in
    private final Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        FindAndReplace findAndReplace = new FindAndReplace();
        findAndReplace.run();
    }

    public void run() {
        /* Your code goes here */
        System.out.println("What is the search word?");
        String searchWord = userInput.nextLine();

        System.out.println("What is the replacement word?");
        String replacementWord = userInput.nextLine();

        System.out.println("What is the source file?");
        String sourceFile = userInput.nextLine();

        System.out.println("What is the destination file?");
        String destinationFile = userInput.nextLine();

        File source = new File(sourceFile);
        File destination = new File(destinationFile);

        try(Scanner reader = new Scanner(source); PrintWriter writer = new PrintWriter(destination)){

            while(reader.hasNext()){
                String line = reader.nextLine();
                writer.println(line.replace(searchWord, replacementWord));
            }

        } catch (Exception ex){
            System.out.println("Something went wrong");
        }

    }

}
