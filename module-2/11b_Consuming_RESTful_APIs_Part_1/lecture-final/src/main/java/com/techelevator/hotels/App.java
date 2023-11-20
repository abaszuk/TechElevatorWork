package com.techelevator.hotels;

import com.techelevator.hotels.model.Hotel;
import com.techelevator.hotels.model.Review;
import com.techelevator.hotels.services.ConsoleService;
import com.techelevator.hotels.services.HotelService;

import java.util.Scanner;

public class App {

    private final ConsoleService consoleService = new ConsoleService();
    private final HotelService hotelService = new HotelService();

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

    private void run() {
        int menuSelection = -1;

        while (menuSelection != 0) {
            consoleService.printMainMenu();
            menuSelection = consoleService.promptForMenuSelection();
            if (menuSelection == 1) {
                Hotel[] hotels = hotelService.listHotels();
                consoleService.printHotels(hotels);
            } else if (menuSelection == 2) {
                Review[] reviews = hotelService.listReviews();
                consoleService.printReviews(reviews);
            } else if (menuSelection == 3) {

                System.out.println("Enter the hotel id:");
                Scanner input = new Scanner(System.in);
                int id = Integer.parseInt(input.nextLine());

                Hotel hotel = hotelService.getHotelById(id);
                consoleService.printHotel(hotel);
            } else if (menuSelection == 4) {
                Review[] reviews = hotelService.getReviewsByHotelId(1);
                consoleService.printReviews(reviews);
            } else if (menuSelection == 5) {
                Hotel[] hotels = hotelService.getHotelsByStarRating(4);
                consoleService.printHotels(hotels);
            } else if (menuSelection == 6) {
                System.out.println("Not implemented - Create a custom Web API query here");
            } else if (menuSelection == 0) {
                continue;
            } else {
                System.out.println("Invalid Selection");
            }
            consoleService.pause();
        }
    }

}
