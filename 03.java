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

    Scanner sc =new Scanner(System.in);

    static int[] accountNumberarry = new int[5];
    static String[] accountHolderarry = new String[5];
    static double[] balancearry = new double[5];

    int numbeofbankaccounts = 0;
    char choice;

    void addnewAccount(){
        do{
            System.out.println("-----add new account------");
            System.out.println("enter account number: ");
            accountNumberarry[numbeofbankaccounts] = sc.nextInt();

            sc.nextLine();
            System.out.println("enter account holdaer name:");
            accountHolderarry[numbeofbankaccounts]= sc.nextLine();

            System.out.println("enter balance:");
            balancearry[numbeofbankaccounts]= sc.nextInt();

            numbeofbankaccounts++;

            System.out.print("Do you want to add another account (y/n)? ");
            sc.nextLine(); // <-- consume the leftover newline
            String line = sc.nextLine();
            if (line.isEmpty()) {
                choice = 'n'; // default to 'n' if user enters nothing
            } else {
                choice = line.charAt(0);
            }

        }
        while(choice == 'y');
    }
    public void withdrawFromAccount() {

        BankAccount bank = new BankAccount(01,"sst",30.2);

        System.out.println("Enter account number 0-4");
        int accNum = sc.nextInt();

        System.out.println("Enter amount to withdraw: ");
        double amounta = sc.nextDouble();
        
        bank.withdraw(balancearry[accNum]);



    }
    void Display(){
         for (int i = 0; i < 5; i++) {
            
            BankAccount v = new BankAccount(accountNumberarry[i],accountHolderarry[i],balancearry[i]);
            System.out.println(v.getaccountNumber() + "\t" + v.getaccountHolder() + "\t\t" + v.getbalance());
        }
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        Bank obj = new Bank();

        int choose;

        do{
            System.out.println("----welcome to Bank");
            System.out.println("1. Add new bank account");
            System.out.println("2.Withdraw");
             System.out.println("3. Display Accounts");
            System.out.println("4.exist");

            choose = sc.nextInt();

            if(choose == 1){
                obj.addnewAccount();
            }
            else if(choose == 2){
                obj.withdrawFromAccount();
            }
            else if(choose == 3){
                obj.Display();
            }
            else{
                break;
            }

        }
        while(choose != 4 );

    }
}