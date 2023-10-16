package com.techelevator;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		//scanner
		Scanner scanner = new Scanner(System.in);
		//system.out.println ask them for what number
		System.out.println("Please provide an integer:");
		//store the input the users give us using the scanner
		String userInput = scanner.nextLine();
		//convert to int
		Integer userNum = Integer.parseInt(userInput);
		System.out.println("Print the sequence till " + userNum );
		//If the input is 0 or a negative number, print "0, 1"
		int firstNum = 0;
		int secondNum = 1;
		//If the input is 1, print "0, 1, 1"
		if (userNum <= 0){
			System.out.println("0, 1");
		} if (userNum == 1){
			System.out.println("0, 1, 1");
		}
		//If the input is a number that appears in the Fibonacci sequence, print the sequence up to and including that number
		for (int i = 2; i <= userNum; i += 2) {
			int nextNum = firstNum + secondNum;
			System.out.println(firstNum + ", ");
			firstNum = secondNum;
			secondNum = nextNum;

			if (firstNum > userNum) {
				break;
			}
		}

	}

}
