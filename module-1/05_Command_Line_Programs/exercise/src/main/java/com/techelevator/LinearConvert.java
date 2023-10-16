package com.techelevator;

import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {
		//scanner
		Scanner scanner = new Scanner(System.in);
		//system.out.println ask them for what distance
		System.out.println("Please enter the length: ");
		//store the input the users give us using the scanner
		String userInput = scanner.nextLine();
		//convert to double
		Double userLength = Double.parseDouble(userInput);
		//Is the distance in feet, or meters?
		//prompt the user for F or M
		System.out.println("Is the measurement in Feet or Meters? Please enter F or M");
		String unit = scanner.nextLine();
		//if statement for whether F or M
		if ("M".equals(unit)){
			double feet = userLength * 3.2808399;
			System.out.println(userLength + " is " + feet + "F");
		} else { //otherwise if F
			double meter = userLength * 0.3048;
			System.out.println(userLength + " is " + meter + "M");
		}



	}

}
