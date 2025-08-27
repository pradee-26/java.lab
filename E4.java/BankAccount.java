package exp4;

import java.util.Scanner;

class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount + " | New Balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + " | New Balance: " + balance);
        } else if (amount > balance) {
            System.out.println("Insufficient balance! Current Balance: " + balance);
        } else {
            System.out.println("Invalid withdrawal amount!");
        }
    }

    public void displayAccount() {
        System.out.println("\n--- Account Details ---");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name   : " + holderName);
        System.out.println("Balance       : " + balance);
    }
}

class BankAccountManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Account Number for Account 1: ");
        String accNo1 = sc.nextLine();
        System.out.print("Enter Holder Name for Account 1: ");
        String name1 = sc.nextLine();
        System.out.print("Enter Initial Balance for Account 1: ");
        double bal1 = sc.nextDouble();
        sc.nextLine(); 

        BankAccount account1 = new BankAccount(accNo1, name1, bal1);

        System.out.print("\nEnter Account Number for Account 2: ");
        String accNo2 = sc.nextLine();
        System.out.print("Enter Holder Name for Account 2: ");
        String name2 = sc.nextLine();
        System.out.print("Enter Initial Balance for Account 2: ");
        double bal2 = sc.nextDouble();

        BankAccount account2 = new BankAccount(accNo2, name2, bal2);

        int choice;
        do {
            System.out.println("\n--- Bank Account Menu ---");
            System.out.println("1. Deposit to Account 1");
            System.out.println("2. Withdraw from Account 1");
            System.out.println("3. Display Account 1 Details");
            System.out.println("4. Deposit to Account 2");
            System.out.println("5. Withdraw from Account 2");
            System.out.println("6. Display Account 2 Details");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double d1 = sc.nextDouble();
                    account1.deposit(d1);
                    account1.displayAccount();
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double w1 = sc.nextDouble();
                    account1.withdraw(w1);
                    account1.displayAccount();
                    break;
                case 3:
                    account1.displayAccount();
                    break;
                case 4:
                    System.out.print("Enter amount to deposit: ");
                    double d2 = sc.nextDouble();
                    account2.deposit(d2);
                    account2.displayAccount();
                    break;
                case 5:
                    System.out.print("Enter amount to withdraw: ");
                    double w2 = sc.nextDouble();
                    account2.withdraw(w2);
                    account2.displayAccount();
                    break;
                case 6:
                    account2.displayAccount();
                    break;
                case 7:
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 7);

        sc.close();
    }
}
