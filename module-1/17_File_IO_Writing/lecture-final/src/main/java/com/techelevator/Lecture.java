package com.techelevator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Lecture {

	public static void main(String[] args) throws IOException {

		Scanner userInput = new Scanner(System.in);

		/*
		 * The java.io.File class is a representation of file and directory path names.  It provides methods to inspect and
		 * modify file system objects.
		 *
		 * One benefit is that it compensates for differences in Windows and Unix use of '/' and '\' as directory delimiters.
		 *
		 * A new instance of File can be created from a String that contains a file system path
		 */


		System.out.println("Please enter the fully qualified file name");

		String fileName = userInput.nextLine();

		File file = new File(fileName);

		//If the file does not exist then create it
		if(!file.exists()){
			file.createNewFile();
		} else {
			System.out.println("How large is this file: " + file.length());
			System.out.println("When was the file last modified:" + file.lastModified());
			System.out.println("What is the absolute path of the file:" + file.getAbsolutePath() );

		}


/*
		System.out.println("Please enter the name of a new directory you want to create");
		String directoryName = userInput.nextLine();
		File directory = new File(directoryName);

		if(!directory.exists()){
			directory.mkdir();
		}
*/

		//This is going to overwrite any existing file content
		try(PrintWriter writer = new PrintWriter(file)){

			for(int i = 0; i < 10; i++){
				writer.println("This is line " + i);
			}

		} catch(Exception ex){
			System.out.println("Something went wrong writing to the file");
		}

		//If we want to keep the existing file content and just append to the end
		try(PrintWriter writer = new PrintWriter(new FileOutputStream(file, true))){

			for(int i = 10; i < 20; i++){
				writer.println("This is line " + i);
			}

		} catch(Exception ex){
			System.out.println("Something went wrong writing to the file");
		}

		//NEVER read and write from the same file in the same try with resources block
		//Instead keep them separate if you have to use the same file

		//But if you're reading from one file and saving to another, then we can utilize the
		//same try with resources block
		String duplicateFileName = "C:\\Test\\Uppercase.txt";
		File duplicateFile = new File(duplicateFileName);

		try(Scanner fileReader = new Scanner(file);
			PrintWriter writer = new PrintWriter(duplicateFile)) {

			while(fileReader.hasNextLine()){

				String line = fileReader.nextLine();
				writer.println(line.toUpperCase());

			}


		} catch(Exception ex){
			System.out.println("Error duplicating file");
		}


	}

}
