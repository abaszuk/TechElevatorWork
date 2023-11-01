package com.techelevator;

import java.io.File;
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

		System.out.println("Please enter the fully qualified file name.");

		String fileName = userInput.nextLine();

		File file = new File(fileName);

		//if the file does not exist create it
		if (!file.exists()){
			file.createNewFile();
		} else {
			System.out.println("How large is this file: " + file.length());
			System.out.println("When was the file last modified: " + file.lastModified());
			System.out.println("What is the absolute path of the file: " + file.getAbsolutePath());
		}



		System.out.println("Please enter the name of a new directory you want to create");
		String directoryName = userInput.nextLine();
		File directory = new File(directoryName);

		if (!directory.exists()){
			directory.mkdir();
		}


	}

}
