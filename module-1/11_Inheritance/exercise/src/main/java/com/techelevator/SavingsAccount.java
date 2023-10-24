package com.techelevator;

public class SavingsAccount extends BankAccount{
    private int serviceCharge = 2;
    private int minimumBalance = 150;

    public SavingsAccount(String accountHolderName, String accountNumber, int balance){
        super(accountHolderName, accountNumber, balance);
    }
    public SavingsAccount(String accountHolderName, String accountNumber){
        super(accountHolderName, accountNumber);
    }
    @Override
    public int withdraw(int amountToWithdraw){
        if (getBalance() <= 0){
            return getBalance();
        }
        int balance = getBalance() - amountToWithdraw;
        if (balance >= minimumBalance){
            super.withdraw(amountToWithdraw);
        }
        if (balance < minimumBalance && balance > 1){
            super.withdraw(amountToWithdraw + serviceCharge);
        }
        return balance;
    }

}
