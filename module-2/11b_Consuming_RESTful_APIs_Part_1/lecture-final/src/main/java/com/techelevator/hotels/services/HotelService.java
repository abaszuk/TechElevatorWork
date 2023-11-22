package com.techelevator.hotels.services;

import com.techelevator.hotels.model.City;
import com.techelevator.hotels.model.Hotel;
import com.techelevator.hotels.model.PicOfDay;
import com.techelevator.hotels.model.Review;
import org.springframework.web.client.RestTemplate;

public class HotelService {

    private static final String API_BASE_URL = "http://localhost:3000";
    private final RestTemplate restTemplate = new RestTemplate();

    public Hotel[] listHotels() {

        String url = API_BASE_URL + "/hotels";

        Hotel[] hotels = restTemplate.getForObject(url, Hotel[].class );

        return hotels;
    }

    public Review[] listReviews() {
        String url = "http://localhost:3000/reviews";
        Review[] reviews = restTemplate.getForObject(url, Review[].class);
        return reviews;
    }

    public Hotel getHotelById(int id) {
        String url = API_BASE_URL + "/hotels/" + id;
        Hotel hotel = restTemplate.getForObject(url, Hotel.class);
        return hotel;
    }

    public Review[] getReviewsByHotelId(int hotelId) {
        //localhost:3000/hotels/1/reviews
        String url = API_BASE_URL + "/hotels/" + hotelId + "/reviews";
        Review[] reviews = restTemplate.getForObject(url, Review[].class);
        return reviews;
    }

    public Hotel[] getHotelsByStarRating(int stars) {
        //localhost:3000/hotels?stars=4
        String url = API_BASE_URL + "/hotels?stars=" + stars;
        Hotel[] hotels = restTemplate.getForObject(url, Hotel[].class);
        return hotels;
    }

    public PicOfDay getWithCustomQuery(){

        String url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY";
        PicOfDay pic = restTemplate.getForObject(url, PicOfDay.class);
        return pic;
    }

}
