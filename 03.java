import java.util.Scanner;

class  BankAccount{
    private int accountNumber;
    private String accountHolder;
    private double balance;

    BankAccount(int accountNumber,String accountHolder,double balance){
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public int getaccountNumber(){
        return accountNumber;
    }
    public void setaccountNumber(int accountNumber){
        this.accountNumber = accountNumber;
    }
    public String getaccountHolder(){
        return accountHolder;
    }
    public void setaccountHolder(String accountHolder){
        this.accountHolder = accountHolder;
    }
    public double getbalance(){
        return balance;
    }
    public void setbalance(int balance){
        this.balance = balance;
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance");
        }
        balance -= amount;
    }
}
class Bank {
    private BankAccount[] accounts = new BankAccount[5];
    private int count = 0;

    public void addAccount(BankAccount account) {
        if (count < 5) {
            accounts[count] = account;
            count++;
        } else {
            System.out.println("Bank is full. Cannot add more accounts.");
        }
    }

    public void withdrawFromAccount(int accNum, double amount) {
        for (int i = 0; i < count; i++) {
            if (accounts[i].getaccountNumber() == accNum) {
                try {
                    accounts[i].withdraw(amount);
                    System.out.println("Withdrawal successful for account " + accNum);
                } catch (IllegalArgumentException e) {
                    System.out.println("Error for account " + accNum + ": " + e.getMessage());
                }
                return;
            }
        }
        System.out.println("Account " + accNum + " not found.");
    }

    public void displayAccounts() {
        System.out.println("acconut\t holder\t balance");
        for (int i = 0; i < count; i++) {
            System.out.println(accounts[i].getaccountNumber() +"\t " + accounts[i].getaccountHolder() +"\t "+ accounts[i].getbalance());
        }
    }

     public static void main(String[] args) {
        Bank bank = new Bank();

        bank.addAccount(new BankAccount(1001, "Alice", 5000.0));
        bank.addAccount(new BankAccount(1002, "Bob", 3000.0));


        bank.withdrawFromAccount(1001, 6000.0);
        bank.withdrawFromAccount(1002, 1000.0); 

        bank.displayAccounts();
    }
}
