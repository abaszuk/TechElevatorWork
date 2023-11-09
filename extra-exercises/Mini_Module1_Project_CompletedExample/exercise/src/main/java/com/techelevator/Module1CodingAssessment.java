package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Module1CodingAssessment {

	public static void main(String[] args) {

		TellerMachine teller = new TellerMachine("Umbrella Corp.", 100, 25);

		System.out.println("Manufacturer is: " + teller.getManufacturer());
		System.out.println("Deposits are: " + teller.getDeposits());
		System.out.println("Withdrawals are: " + teller.getWithdrawals());
		System.out.println("Balance is: " + teller.getBalance());

		System.out.println(teller);

		List<TellerMachine> list = new ArrayList<TellerMachine>();
		File myFile = new File("data-files/TellerInput.csv");
		try(Scanner scan = new Scanner(myFile)) {

			while(scan.hasNextLine()){
				String line = scan.nextLine();
				String[] parts = line.split(",");
				String manufacturer = parts[0];
				int deposits = (int)Double.parseDouble(parts[1]);
				int withdrawals = (int)Double.parseDouble(parts[2]);

				list.add(new TellerMachine(manufacturer, deposits, withdrawals));
			}

		} catch(FileNotFoundException ex){
			System.out.println("File was not found");
		}

		int balance = 0;
		for(TellerMachine t : list) {
			balance += t.getBalance();
		}

		System.out.println("Balance is " + balance);

	}

}
