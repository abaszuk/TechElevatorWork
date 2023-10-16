package com.techelevator;

import java.util.Scanner;

class DiscountCalculator {

    /**
     * The main method is the start and end of our program
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Discount Calculator");


        System.out.print("Enter the discount amount (w/out percentage): ");
        // Prompt the user for a discount amount
        String discountAmtStr = scanner.nextLine();

        // The answer needs to be saved as a double
        double discountAmt = Double.parseDouble(discountAmtStr);



        System.out.print("Please provide a series of prices (space separated): ");
        // Prompt the user for a series of prices
        String prices = scanner.nextLine();

        //String array - split on space
        String[] priceList = prices.split(" ");


        for(int i=0; i < priceList.length; i++) {
            // Parse each of them into ints
            double price = Double.parseDouble(priceList[i]);

            //Print out each price with the discount applied
            double discount =  price * (discountAmt/100);
            double newPrice = price - discount;
            System.out.println(priceList[i] + " is discounted to " + newPrice);
        }
    }

}