package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class BankCustomer {
    private String name;
    private String address;
    private String phoneNumber;

    private List<Accountable> accounts = new ArrayList<>();

    public String getName(){
        return name;
    }
    public String getAddress(){
        return address;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public BankCustomer(String name, String address, String phoneNumber, List<Accountable> accounts){
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.accounts = accounts;
    }
    public BankCustomer(){

    }

    public Accountable[] getAccounts(){
        return accounts.toArray(new Accountable[accounts.size()]);
    }

    public void setName(String name){
        this.name = name;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    public void addAccount(Accountable newAccount){
        accounts.add(newAccount);
    }


    public boolean isVip(){
        int totalBalance = 0;
       for (Accountable account : accounts ){
           totalBalance += account.getBalance();
           } if (totalBalance >= 25000){
            return true;
       }return false;
    }


}
