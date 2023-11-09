package com.techelevator;

public class TellerMachine {

    //manufacturer: indicates the manufacturer name for the teller machine.
    private String manufacturer;

    //deposits: indicates the total amount that has been deposited into the machine.
    private int deposits;

    //withdrawals: indicates the total amount that has been withdrawn from the machine.
    private int withdrawals;

    public TellerMachine(String manufacturer, int deposits, int withdrawals) {
        this.manufacturer = manufacturer;
        this.deposits = deposits;
        this.withdrawals = withdrawals;
    }

    //balance: indicates the net difference between deposits and withdrawals.
    public int getBalance() {
        int balance = deposits - withdrawals;
        return balance;
    }

    // getters and setters
    public String getManufacturer() {
        return this.manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getDeposits(){
        return this.deposits;
    }

    public void setDeposits(int deposits){
        this.deposits = deposits;
    }

    public int getWithdrawals(){
        return withdrawals;
    }

    public void setWithdrawals(int withdrawals) {
        this.withdrawals = withdrawals;
    }

    //Create a method that checks to see if a string parameter, cardNumber, is a valid card. The method only returns true under the following conditions:
    public boolean isCardNumberValid(String cardNumber) {


        //If the cardNumber begins with a 5 and has 16 digits
        if((cardNumber.startsWith("5") && cardNumber.length() == 16)  ||
           //If the cardNumber begins with a 4 and has 13 or 16 digits
           (cardNumber.startsWith("4") && (cardNumber.length() == 13 || cardNumber.length() == 16)) ||
           //If the cardNumber begins with a 3 and is followed by a 4 or a 7
           (cardNumber.startsWith("34") || cardNumber.startsWith("37") )
        ){
            return true;
        }

        return false;
    }

    @Override
    public String toString() {

        return "ATM - " + manufacturer + " - " + getBalance();
    }
}
