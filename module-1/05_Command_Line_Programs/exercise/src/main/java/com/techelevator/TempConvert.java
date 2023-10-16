package com.techelevator;

import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {
		//scanner
		Scanner scanner = new Scanner(System.in);

		//system.out.println ask them for what temperature
		System.out.println("Please enter the temperature:");

		//store the input the users give us using the scanner
		String userInput = scanner.nextLine();

		//convert to double
		Double userTemp = Double.parseDouble(userInput);

		//Is the temperature in (C)elsius, or (F)ahrenheit? F
		//prompt the user for C or F
		System.out.println("Is the temperatuire in (C)elsius, or (F)ahrenheit? Please enter C or F");
		String givenUnit = scanner.nextLine();

		//if statement for whether celsius or F
		//if celsius
		if ("C".equals(givenUnit)) {


			double temperatureFarenheit = userTemp * 1.8 + 32;
			System.out.println(userInput + "C is " + temperatureFarenheit + "F");
		} else {
			//otherwise if F
			double temperatureCelsius = (userTemp - 32) / 1.8;
			System.out.println(userInput + "F is " + temperatureCelsius + "C");
		}
		//58F is 14C.



	}

}
