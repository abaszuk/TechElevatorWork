package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;

public class WordSearch {

	// Use this scanner for all user input. Don't create additional Scanners with System.in
	private final Scanner userInput = new Scanner(System.in);

	public static void main(String[] args) {
		WordSearch wordSearch = new WordSearch();
		wordSearch.run();
	}

	public void run() {
		/* Your code goes here */
		System.out.println("What is the fully qualified name of the file that should be searched?");
		String fileName = userInput.nextLine();

		System.out.println("What is the search word you are looking for?");
		String searchWord = userInput.nextLine();

		System.out.println("Should the search be case sensitive? (Y\\N)");
		String caseSensitive = userInput.nextLine();

		File file = new File(fileName);
		int lineNumber = 1;

		try(Scanner fileReader = new Scanner(file)){
			while(fileReader.hasNextLine()){
				String line = fileReader.nextLine();
				if (caseSensitive.equalsIgnoreCase("N") && line.toLowerCase().contains(searchWord.toLowerCase())){
					System.out.println(lineNumber + ") " + line);
				} else if (caseSensitive.equalsIgnoreCase("Y") && line.contains(searchWord)){
					System.out.println(lineNumber + ") " + line);
				} lineNumber++;
			}
		}
		catch (FileNotFoundException ex){
			System.out.println("File not found");
		} catch(Exception ex) {
			System.out.println("Something went wrong");
		}
	}
}
