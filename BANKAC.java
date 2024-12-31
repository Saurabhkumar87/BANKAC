import java.util.ArrayList;
import java.util.Scanner;

class BankAccount{
    private String AccountHolderName;
    private String AccountNumber;
    private double balance;

// CONSTRUCTOR//
public BankAccount(String AccountHolderName,String AccountNumber,double Initialbalance){
    this.AccountHolderName = AccountHolderName;
    this.AccountNumber = AccountNumber;
    this.balance = Initialbalance;
}
//GETTER METHODS//
public String getAccountHolderName(){
    return AccountHolderName;
}
public String getAccountNumber(){
    return AccountNumber;
}
public double getbalance(){
    return balance;
}
// deposited//
public void deposit(double amount){
    if(amount>0){
        balance += amount;
        System.out.println(" Successfully deposited Amount "+amount+" . ");
    }else{
        System.out.println(" Inavlid amount .");
    }
}
//withdrwal//
public void withdrwal(double amount){
    if(amount>0 && amount <= balance){
        balance -= amount;
        System.out.println("Successfully withdrwal amount"+amount);
    }else if(amount>balance){
        System.out.println("Iinsufficient balance");
    }else{
        System.out.println(" invalid withdrwal amount");
    }
}

// displayAccountDetails//
public void displayAccountDetails(){
    System.out.println("Account Holder : "+AccountHolderName);
    System.out.println("Acount number : "+AccountNumber);
    System.out.println("Balance in Rs."+balance);
}
}
class BANKAC{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<BankAccount> accounts = new ArrayList<>();
        System.out.println("Welcome to bank account management system :");
        boolean exit = false;
        while(!exit){
            System.out.println("\nMenu");
            System.out.println("1. Create account");
            System.out.println("2. Display all accounts");
            System.out.println("3. depost amount ");
            System.out.println("4.withdrwal amount");
            System.out.println("5. Check balance");
            System.out.println("6. exit");
            System.out.println("choose an option :");

            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice){
                case 1:// cceate a new a/c
                System.out.println(" please enter the account holder name ");
                String name = sc.nextLine();
                System.out.println("please enter the account number ");
                String accountNumber = sc.nextLine();
                System.out.println(" please enter the Initial amount ");
                double Initialbalance = sc.nextDouble();
               accounts.add(new BankAccount(name, accountNumber, Initialbalance));
               System.out.println(" Account created successfully ");
               break;
              case 2: // display all account
              if(accounts.isEmpty()){
                System.out.println(" No Accounts available ");
              }else{
                System.out.println("Accounts details ");
                for(BankAccount account : accounts){
                    account.displayAccountDetails();
                    System.out.println("*****************");
                }
              }
              break;
              case 3 :// depost  amount
              System.out.println("Enter account number ");
              String depositAccountNumber = sc.nextLine();
              BankAccount depositAccount = findAccount(accounts, depositAccountNumber);
              if(depositAccount!=null){
                         System.out.print("Enter amount to deposit: ");
                        double depositAmount = sc.nextDouble();
                        depositAccount.deposit(depositAmount);

              }else {
                System.out.println("Account not found.");
              }break;
            case 4://withdrwal //
            System.out.println(" Enter account number ");
            String withdrwalAccountNumber = sc.nextLine();
            BankAccount withdrwalAccount = findAccount(accounts, withdrwalAccountNumber);
            if(withdrwalAccount != null){

                System.out.print("Enter amount to withdraw: ");
                double withdrawAmount = sc.nextDouble();
                withdrwalAccount.withdrwal(withdrawAmount);
            } else {
                System.out.println("Account not found.");
            }
            break;
            case 5 :// chcek amount
           System.out.println(" Enter ur acount number ");
           
            String balanceAccountNumber = sc.nextLine();

            BankAccount balanceAccount = findAccount(accounts, balanceAccountNumber);
            if (balanceAccount != null) {
                System.out.println("Current Balance: Rs." + balanceAccount.getbalance());
            } else {
                System.out.println("Account not found.");
            }break;
           case 6: //  exit
           System.out.println("Thank you for using the Bank Account Management System. Goodbye 😊!");
           exit = true;
           break;
           default :
           System.out.println("Invalid option , please try again ");
            }
        }
    }
    // Helper method//
    private static BankAccount findAccount(ArrayList<BankAccount> accounts, String accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
         return null;
    }
}