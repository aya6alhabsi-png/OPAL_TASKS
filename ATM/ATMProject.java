package ATMProject; 

import java.util.Scanner;

public class ATMProject {
     //shared scanner for user input
    static Scanner userInput = new Scanner(System.in);
     
     //declare static variables -->out the main method so that they can be used in all the methods
    static double balance = 1000.00;
    static int pin = 1234;
    static int depositCount = 0;
    static double totalDeposits = 0.00;
    static int withdrawalCount = 0;
    static double totalWithdrawals = 0.00;

    public static void main(String[] args) {

        if (!login()) {//!login -->login not successful -->return false -->exit the program 
            //login is a method -->used to called to check if the user can access the ATM
            userInput.close();
            return;//true /false -->end the main method if login is not successful
        }
         
            //do-while loop to display the menu + user choices
        int choice; //store the user choice

        do { //start of the loop
            menu();
            choice = userInput.nextInt();//user add the choice 

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    accountTier();
                    break;
                case 5:
                    savingsProjection();
                    break;
                case 6:
                    receiptSummary();
                    break;
                case 7:
                    changePin();
                    break;
                case 0:
                    System.out.println("exit");
                    break;
                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 0); //end of the loop (choice != 0) -->if the user choice is not 0 -->continue the loop

        userInput.close();
    }

    //login
    public static boolean login() {
        int attempts = 3;

        while (attempts > 0) {
            System.out.println("Enter PIN");
            int enteredPin = userInput.nextInt();

            if (enteredPin == pin) { //pin is set as var by default to 1234 -->if the user enter the correct pin -->return true
                System.out.println("Welcome");
                return true;
            }

            attempts--; //reduce the attempts by 1 if the PIN is wrong
             
             //check the number of attempts left +how many remain
            if (attempts > 0) {
                System.out.println("Attempts left: " + attempts);
            } else {
                System.out.println("Card locked");
            }
        }

        return false; //if all 3 attempts used 
    }

    //the menu methpd to display the options to the user
    public static void menu() {
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Account Tier");
        System.out.println("5. Savings Projection");
        System.out.println("6. Receipt Summary");
        System.out.println("7. Change PIN");
        System.out.println("0. Exit");
        System.out.print("Choose an option: ");
    }

    // checkbalance
    public static void checkBalance() {
        System.out.printf("balance: %.2f%n", balance);//%.2f -->display 2 decimal places
    }

    //deposit
     public static void deposit() {
        System.out.println("Enter deposit amount");
        double amount = userInput.nextDouble();

        if (amount <= 0 || amount > 5000) {
            System.out.println("the amount should be greater than 0 and less than or equal to 5000");
            return;
        }
        balance += amount;
        depositCount++;
        totalDeposits += amount;

        System.out.printf("deposit successful Balance: %.2f%n", balance); //%.2f -->display 2 decimal places
    }

    //withdraw
    public static void withdraw() {
        System.out.println("Enter withdrawal amount");
        double amount = userInput.nextDouble();

        if (amount <=0) {
            System.out.println("amount must be greater than 0.");
            return;
        }

        if (amount % 10 != 0) {
            System.out.println("Amount must be a multiple of 10."); 
            return;
        }

        if (totalWithdrawals + amount > 1000) {
            System.out.println("withdrawal limit is 1000.00.");
            System.out.printf("Remaining withdrawal limit: %.2f%n",
                    1000.00 - totalWithdrawals);
            return;
        }

        double fee;

        if (amount <= 500) {
            fee = 2.00;
        } else {
            fee = 5.00;
        }

        if (balance < amount + fee) {
            System.out.println("Insufficient balance to cover the amount and fee");
            System.out.printf("Fee: %.2f%n", fee);
            return;
        }

        balance -= amount + fee;
        withdrawalCount++;
        totalWithdrawals += amount;

        System.out.printf("Fee: %.2f%n", fee);
        System.out.printf("Withdrawal successful. Balance: %.2f%n", balance);
    }

    //account tier
    public static void accountTier() {
        System.out.printf("Tier: %s, interest rate: %.0f%%%n",
                getTier(), getInterestRate() * 100);
    }

    // Get account tier
    public static String getTier() {
        if (balance < 1000) {
            return "Bronze";
        } else if (balance < 5000) {
            return "Silver";
        } else if (balance < 20000) {
            return "Gold";
        } else {
            return "Platinum";
        }
    }

    // Get interest rate
    public static double getInterestRate() {
        if (balance < 1000) {
            return 0.01;
        } else if (balance < 5000) {
            return 0.02;
        } else if (balance < 20000) {
            return 0.03;
        } else {
            return 0.04;
        }
    }

    //Savings projection
    public static void savingsProjection() {
        System.out.println("Enter number of years");
        int years = userInput.nextInt();

        if (years < 1 || years > 10) {
            System.out.println("Enter a number from 1 to 10.");
            return;
        }

        double projectedBalance = balance;
        double rate = getInterestRate();

        for (int i = 1; i <= years; i++) {
            projectedBalance *= (1 + rate);
            System.out.printf("Year %d: %.2f%n", i, projectedBalance); //%.2f -->display 2 decimal places
            //%d -->display integer
        }
    }

    //Receipt summary
    public static void receiptSummary() {
        System.out.printf("Deposits: %d, total: %.2f%n",
                depositCount, totalDeposits);

        System.out.printf("Withdrawals: %d, total: %.2f%n",
                withdrawalCount, totalWithdrawals);

        System.out.printf("Balance: %.2f%n", balance);
    }

    //Change pin
    public static void changePin() {
        System.out.println("Enter old PIN");
        int oldPin = userInput.nextInt();

        if (oldPin != pin) {
            System.out.println("Error: Incorrect old PIN.");
            return;
        }

        System.out.println("Enter new PIN (4 digits)");
        int newPin = userInput.nextInt();

        if (newPin < 1000 || newPin > 9999) {
            System.out.println("pinmust contain exactly 4 digits.");
            return;
        }

        System.out.println("Confirm new PIN");
        int confirmPin = userInput.nextInt();

        if (newPin != confirmPin) {
            System.out.println("Error: PINs do not match.");
            return;
        }

        pin = newPin;
        System.out.println("PIN changed successfully.");
    }
}
