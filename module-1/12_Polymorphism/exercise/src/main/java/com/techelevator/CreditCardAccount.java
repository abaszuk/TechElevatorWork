package com.techelevator;

public class CreditCardAccount implements Accountable{
    public CreditCardAccount(String accountHolderName, String accountNumber){
        this.accountHolderName = accountHolderName;
        this.cardNumber = accountNumber;
    }

    private String accountHolderName;
    private String cardNumber;
    private int debt;
    private int balance;

    public String getAccountHolderName(){
       return this.accountHolderName;
    }
    public String getCardNumber(){
        return this.cardNumber;
    }
    public int getDebt(){
        return this.debt;
    }
    public int getBalance(){
        return this.debt*-1;
    }

    public int pay(int amountToPay){
        if (amountToPay >0){
            debt -= amountToPay;
        } return debt;
    }
    public int charge(int amountToCharge){
        if (amountToCharge > 0){
            debt += amountToCharge;
        } return debt;
    }
}
