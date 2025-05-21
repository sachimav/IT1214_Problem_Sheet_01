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
    public int setaccountNumber(int accountNumber){
        this.accountNumber = accountNumber;
    }
    public String getaccountHolder(){
        return accountHolder;
    }
    public String setaccountHolder(String accountHolder){
        this.accountHolder = accountHolder;
    }
    public double getbalance(){
        return balance;
    }
    public double setbalance(int balance){
        this.balance = balance;
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance");
        }
        balance -= amount;
    }
}
class Bank{

    Scanner sc =new Scanner(System.in);

    static int[] accountNumberarry = new int[5];
    static String[] accountHolderarry = new String[5];
    static int[] balancearry = new int[5];

    int numbeofbankaccounts = 0;
    char choice;

    void addnewAccount(){
        do{
            System.out.println("-----add new account------");
            System.out.println("enter account number: ");
            accountHolderarry[numbeofbankaccounts] = sc.nextInt();

            sc.nextLine();
            System.out.println("enter account holdaer name:");
            accountHolderarry[numbeofbankaccounts]= sc.nextLine();

            System.out.println("enter balance:");
            balancearry[numbeofbankaccounts]= sc.nextInt();

            numbeofbankaccounts++;

            System.out.println("do you want add new account y || n");
            choice = sc.nextChar();

        }
        while(choice == 'y');
    }
    void Display(){
        for(int i = 0 ; i<5 ; i++){
            System.out.println("Accountnum\t holder\t balance");
            System.out.println(accountNumberarry[i]+"\t "+accountHolderarry[i]+"\t"+balancearry[i]);

        }
    }

    public static void main(String[] args){

        Bank obj = new Bank();

        int choose;

        do{
            System.out.println("----welcome to Bank");
            System.out.println("1. Add new bank account");
            System.out.println("2.Withdraw");
             System.out.println("4. Display Accounts");
            System.out.println("3.exist");

            choose = sc.nextInt();

            if(choose == 1){
                obj.addnewAccount();
            }
            else if(choose == 2){
                obj.Withdraw();
            }
            else if(choose == 3){
                obj.Display();
            }

        }
        while(choose != 3 );

    }
}