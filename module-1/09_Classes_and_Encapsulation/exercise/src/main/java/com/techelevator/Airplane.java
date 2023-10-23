package com.techelevator;

public class Airplane {
    private String planeNumber;
    private int totalFirstClassSeats;
    private int bookedFirstClassSeats;
    private int totalCoachSeats;
    private int bookedCoachSeats;

    //getters
    public int getAvailableFirstClassSeats(){
        return totalFirstClassSeats - bookedFirstClassSeats;
    }

    public int getAvailableCoachSeats(){
        return totalCoachSeats - bookedCoachSeats;
    }

    public String getPlaneNumber(){
        return planeNumber;
    }

    public int getTotalFirstClassSeats(){
        return totalFirstClassSeats;
    }

    public int getBookedFirstClassSeats(){
        return bookedFirstClassSeats;
    }

    public int getTotalCoachSeats(){
        return totalCoachSeats;
    }

    public int getBookedCoachSeats(){
        return bookedCoachSeats;
    }

    //constructors
    public Airplane(String planeNumber, int totalFirstClassSeats, int totalCoachSeats){
        this.planeNumber = planeNumber;
        this.totalFirstClassSeats = totalFirstClassSeats;
        this.totalCoachSeats = totalCoachSeats;
    }

    //method
    public boolean reserveSeats(boolean forFirstClass, int totalNumberOfSeats) {
        if (totalNumberOfSeats < getAvailableCoachSeats() || totalNumberOfSeats < getAvailableFirstClassSeats()) {

            if (forFirstClass) {
                bookedFirstClassSeats += totalNumberOfSeats;
            } else {
                bookedCoachSeats += totalNumberOfSeats;
            }return true;

        } return false;
    }

}
