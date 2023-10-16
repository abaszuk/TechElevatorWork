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

        //String array
        String[] priceList = prices.split(" ");


        for (int i = 0; i < priceList.length; i++){
            //Parse each of them into ints
            int price = Integer.parseInt(priceList[i]);

            double wDiscount = price - (price * (discountAmt/100));

            System.out.println(priceList[i] + " becomes " + wDiscount); //Print out the price with the discount price
        }








    }

}