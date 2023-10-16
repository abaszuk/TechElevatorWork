package com.techelevator;

import java.util.Scanner;

public class DecimalToBinary {

	public static void main(String[] args) {
		//scanner
		Scanner scanner = new Scanner(System.in);
		// Please enter a series of decimal values (separated by spaces)
		System.out.println("Please enter a series of decimal values separated by spaces:");
		//store the input the users give us using the scanner
		String userInput = scanner.nextLine();
		//create array for user input
		String[] numList = userInput.split(" ");
		//convert to int
		for (int i = 0; i < numList.length; i++) {
			Integer userDecimals = Integer.parseInt(numList[i]);
			//binaryString used once we have input
			String binaryString = Integer.toBinaryString(userDecimals);
			System.out.println(userDecimals + " in binary is " + binaryString);

		}
	}

}