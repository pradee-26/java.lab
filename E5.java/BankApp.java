package BankApp;
import java.util.Scanner;


class Account {
 protected String custName;
 protected int accNo;
 protected double balance;

 public Account(String custName, int accNo, double balance) {
     this.custName = custName;
     this.accNo = accNo;
     this.balance = balance;
 }

 public void viewBalance() {
     System.out.println("\n--- Account Details ---");
     System.out.println("Account No   : " + accNo);
     System.out.println("Customer Name: " + custName);
     System.out.println("Balance      : " + balance);
 }

 public void deposit(double amount) {
     balance += amount;
     System.out.println("Deposited: " + amount);
 }

 public void withdraw(double amount) {
     balance -= amount;
     System.out.println("Withdrawn: " + amount);
 }
}

//Sub Class: SavingsAccount
class SavingsAccount extends Account {
 private double interestRate = 0.06;

 public SavingsAccount(String custName, int accNo, double balance) {
     super(custName, accNo, balance);
 }

 public void deposit(double amount) {
     double interest = amount * interestRate;
     balance += amount + interest;
     System.out.println("Deposited: " + amount + " + Interest(6%) = " + (amount + interest));
 }


 public void withdraw(double amount) {
     if (amount > balance) {
         System.out.println("❌ Overdraw not possible in Savings Account!");
     } else {
         balance -= amount;
         System.out.println("Withdrawn: " + amount);
     }
 }
}


class CurrentAccount extends Account {
 private double serviceChargeRate = 0.035;

 public CurrentAccount(String custName, int accNo, double balance) {
     super(custName, accNo, balance);
 }

 public void withdraw(double amount) {
     if (amount > balance) {
         double overdraw = amount - balance;
         double serviceCharge = overdraw * serviceChargeRate;
         balance -= (amount + serviceCharge);
         System.out.println("⚠️ Overdrawn: " + overdraw + " | Service Charge: " + serviceCharge);
     } else {
         balance -= amount;
         System.out.println("Withdrawn: " + amount);
     }
 }

 public void deposit(double amount) {
     balance += amount;
     System.out.println("Deposited: " + amount + " (No Interest)");
 }
}


public class BankApp {
 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     Account acc = null;

     System.out.println("Choose Account Type:");
     System.out.println("1. Savings Account");
     System.out.println("2. Current Account");
     int choice = sc.nextInt();
     sc.nextLine();

     System.out.print("Enter Customer Name: ");
     String name = sc.nextLine();
     System.out.print("Enter Account Number: ");
     int accNo = sc.nextInt();
     System.out.print("Enter Initial Balance: ");
     double balance = sc.nextDouble();

     if (choice == 1) {
         acc = new SavingsAccount(name, accNo, balance);
     } else if (choice == 2) {
         acc = new CurrentAccount(name, accNo, balance);
     } else {
         System.out.println("Invalid choice!");
         System.exit(0);
     }

     int option;
     do {
         System.out.println("\n--- Bank Menu ---");
         System.out.println("1. View Balance");
         System.out.println("2. Deposit");
         System.out.println("3. Withdraw");
         System.out.println("4. Exit");
         System.out.print("Enter choice: ");
         option = sc.nextInt();

         switch (option) {
             case 1:
                 acc.viewBalance();
                 break;
             case 2:
                 System.out.print("Enter deposit amount: ");
                 double dep = sc.nextDouble();
                 acc.deposit(dep);
                 break;
             case 3:
                 System.out.print("Enter withdraw amount: ");
                 double wd = sc.nextDouble();
                 acc.withdraw(wd);
                 break;
             case 4:
                 System.out.println("Exiting...");
                 break;
             default:
                 System.out.println("Invalid option!");
         }
     } while (option != 4);

     sc.close();
 }
}
