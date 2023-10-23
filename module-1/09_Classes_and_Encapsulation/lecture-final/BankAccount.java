public class BankAccount {

    private String accountNumber;
    private String type; //to indicate Checking or Savings, etc.

    private String routingNumber;

    private double balance;

    public BankAccount(){
        //doing nothing
    }
    public BankAccount(String accountNumber, String type,
                       String routingNumber){
        this.accountNumber = accountNumber;
        this.type = type;
        this.routingNumber = routingNumber;

    }

    public String getAccountNumber(){
        return "xxxxxxxxxx" + accountNumber
                .substring(accountNumber.length()-4);

    }

    public void setAccountNumber(String accountNumber){
        this.accountNumber = accountNumber;
    }

    public String getType(){
        return type;
    }

    public void setType(String type){
        this.type = type;
    }

    public void setRoutingNumber(String routingNumber){
        this.routingNumber = routingNumber;
    }
}
