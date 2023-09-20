import java.util.Scanner;

// Step 4: Create a class to represent the user's bank account.
class BankAccount {
    private double balance;
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }
    public double getBalance() {
        return balance;
    }
    public void deposit(double amount) {
        balance += amount;
    }
    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
}
class ATM {
    private BankAccount account;
    public ATM(BankAccount account) {
        this.account = account;
    }
    public void withdraw(double amount) {
        boolean success = account.withdraw(amount);
        if (success) {
            System.out.println("Withdrawal of " + amount + " Rs. is successful.");
        } else {
            System.out.println("Insufficient balance for withdrawal.");
        }
    }
    public void deposit(double amount) {
        account.deposit(amount);
        System.out.println("Deposit of " + amount + " Rs. is successful.");
    }
    public void checkBalance() {
        double balance = account.getBalance();
        System.out.println("Current balance: " + balance+" Rs.");
    }
    public boolean isValidAmount(double amount) {
        return amount > 0;
    }
    public void displayMenu() {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("ATM Menu:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = sc.nextDouble();
                    if (isValidAmount(withdrawalAmount)) {
                        withdraw(withdrawalAmount);
                    } else {
                        System.out.println("Invalid amount.");
                    }
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = sc.nextDouble();
                    if (isValidAmount(depositAmount)) {
                        deposit(depositAmount);
                    } else {
                        System.out.println("Invalid amount.");
                    }
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("Exiting ATM... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 4);
    }
}

public class AtmInterface {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000.0);
        ATM atm = new ATM(userAccount);
        atm.displayMenu();
    }
}

