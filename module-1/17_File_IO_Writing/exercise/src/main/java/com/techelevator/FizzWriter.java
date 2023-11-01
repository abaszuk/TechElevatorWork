package com.techelevator;

import java.io.PrintWriter;
import java.util.Scanner;

public class FizzWriter {

	// Use this scanner for all user input. Don't create additional Scanners with System.in
	private final Scanner userInput = new Scanner(System.in);

	public static void main(String[] args) {
		FizzWriter fizzWriter = new FizzWriter();
		fizzWriter.run();
	}

	public void run() {
		/* Your code goes here */
		System.out.println("What is the destination file?");
		String destinationFile = userInput.nextLine();

		try( PrintWriter writer = new PrintWriter(destinationFile)){

			int lineCounter = 1;
			while(lineCounter <= 300){
				if (lineCounter % 3 == 0 && lineCounter % 5 ==0 ){
					writer.println("FizzBuzz");
				} else if (lineCounter % 3 == 0){
					writer.println("Fizz");
				} else if (lineCounter % 5 ==0){
					writer.println("Buzz");
				} else {
					writer.println(lineCounter);
				} lineCounter++;
			}

		} catch (Exception ex){
			System.out.println("Something went wrong");
		}



	}

}
