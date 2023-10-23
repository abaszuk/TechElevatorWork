public class Main {

    public static void main(String[] args) {

        //by default we always get an empty constructor
        //but keep in mind that if we create a custom
        //constructor that we will lose this default empty one
        //and have to explicitly create one otherwise
        Customer customer1 = new Customer();
        customer1.setName("John");
        System.out.println("This customers name is " + customer1.getName());


        Customer christopher = new Customer("Christopher", 38);

        //Constructors make less work of initializing a class
        BankAccount account = new BankAccount("123456789", "Checking", "10001001");
        System.out.println("Account number is " + account.getAccountNumber());


        //versus creating a new class and setting each field one at a time
        //setters are useful if you need to change the value of data
        BankAccount account2 = new BankAccount();
        account2.setAccountNumber("1234029");
        account2.setType("Savings");
        account2.setRoutingNumber("0102303");

        //add these accounts to christopher
        christopher.openAccount(account);
        christopher.openAccount(account2);

        christopher.listAccounts();

    }
}
