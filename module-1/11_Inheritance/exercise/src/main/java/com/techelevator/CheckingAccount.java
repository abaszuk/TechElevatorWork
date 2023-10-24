package com.techelevator;

public class CheckingAccount extends BankAccount {
    private int overDraftFee = 10;
    private int lowerLimit = -100;

   public CheckingAccount(String accountHolderName, String accountNumber, int balance){
       super(accountHolderName, accountNumber, balance);
   }
   public CheckingAccount(String accountHolderName, String accountNumber){
       super(accountHolderName, accountNumber);
   }

   @Override
    public int withdraw(int amountToWithdraw){
       if (getBalance() <= lowerLimit ){
            return getBalance();
       }
       int balance = getBalance() - amountToWithdraw;
       if (balance >= 0){
           super.withdraw(amountToWithdraw);
       }
       if (balance < 0 && balance > lowerLimit){
           super.withdraw(amountToWithdraw + overDraftFee);
       }
       return balance;
   }


}
