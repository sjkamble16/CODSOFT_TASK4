import java.util.Scanner;

// Bank Account class to store the account balance
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}

// ATM class to interact with the user and access bank account
class ATM {
    private BankAccount bankAccount;
    private Scanner scanner;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
        scanner = new Scanner(System.in);
    }

    public void displayOptions() {
        System.out.println("Welcome to the ATM!");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void start() {
        int option;
        do {
            displayOptions();
            System.out.print("Enter your choice: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    withdraw(); 
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 4);
    }

    private void withdraw() {
        System.out.print("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (amount > 0 && bankAccount.withdraw(amount)) {
            System.out.println("Withdrawal successful. Remaining balance: " + bankAccount.getBalance());
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    private void deposit() {
        System.out.print("Enter the amount to deposit: ");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            bankAccount.deposit(amount);
            System.out.println("Deposit successful. New balance: " + bankAccount.getBalance());
        } else {
            System.out.println("Invalid amount.");
        }
    }

    private void checkBalance() {
        System.out.println("Your current balance: " + bankAccount.getBalance());
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        // Create a bank account with an initial balance of 1000
        BankAccount bankAccount = new BankAccount(1000);

        // Create an ATM instance and connect it to the bank account
        ATM atm = new ATM(bankAccount);

        // Start the ATM interface
        atm.start();
    }
}