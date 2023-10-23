import java.util.ArrayList;
import java.util.List;

public class Customer {

    //DATA - What can we store in this class?

    //public and private are both keywords that we refer to
    //as access modifiers - meaning "who can access this?"
    //private means that only this class that declares
    //can see it, while public means that external classes
    //will be able to see it

    //best practice is to always have our class variables
    //be private and then only let them be accessed by
    //constructors, getters and setters
    private String name;
    private String stateId;
    private String address;

    //if we want to give any of these variable a default
    //we can just have an = value right after it
    private int age=18;

    private List<BankAccount> accounts = new ArrayList<>();

    //Constructors
    //1. These run only once, when the class is being initialized
    //2. Typically used to set values explicitly or provide default values
    //3. Typically public, always named after the class itself
    //4. They can be overloaded, meaning that we can have multiple so long as they
    //have different parameters

    public Customer(){
        //by default every class will have an empty constructor
    }
    public Customer(String name, int age){
        //we can write to oyr data through constructors
        //but keep in mind we cant read
        this.name = name;
        this.age = age;
    }

    //Getters & Setters
    //1. these are just methods that determine
    // how another class can access the data
    //2. getters return data. We normally name them
    //getField with the field representing whichever
    // class variable we are accessing
    //3. setters accept data and save it in the class
    //4. if we only have a getter and no setter then
    // that particular field is read only

    //getter for name field:
    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    //setter for name field
    //typically void is the return type
    //void means nothing is being returned
    //we are only receiving data to save to our class
    //but not returning anything for people to read
    public void setName(String name){
        this.name = name;
    }


    //BEHAVIOR - what can this class do?
    public void openAccount(BankAccount ba){
        accounts.add(ba);
    }

    public void listAccounts(){

        for (BankAccount account : accounts){
            System.out.println(account.getType() + " " + account.getAccountNumber());
        }
    }

}
