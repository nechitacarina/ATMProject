import Menues.ATMMenu;
import Menues.StartMenu;

import java.util.ArrayList;
import java.util.Scanner;

public class ATMActions {

    protected static ArrayList<Account> createAccounts(){
        ArrayList<Account> accounts = new ArrayList<>();
        accounts.add(new Account("Nechita Carina", 1234, '€', 3000.75));
        accounts.add(new Account("Popescu Anamaria", 6585, '$', 132.99));
        return accounts;
    }
    private static final ArrayList<Account> accounts = createAccounts();
    protected static void displayStartMenu(){
        for(StartMenu startMenuOptions : StartMenu.values())
            System.out.println(startMenuOptions.getOptionNumber() + " " + startMenuOptions.getOptionDescription());
        System.out.println("Please choose an option from the menu! Thank you :)");
    }

    private static int readOptionNumberFromConsole(){
        Scanner scanner = new Scanner(System.in);
        boolean isNumber = false;
        int scannedNumber = 0;
        while (!isNumber){
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a number!");
                scanner = new Scanner(System.in);
            }
            scannedNumber = scanner.nextInt();
            isNumber = true;
        }
        return scannedNumber;
    }

    private static Account readCredentials(){
        Account loggedInAccount = null;
        boolean accountFound = false;
        System.out.println("Please enter your name: ");
        Scanner scannedName = new Scanner(System.in);
        String name = scannedName.nextLine();
        System.out.println("Please enter your PIN: ");
        Scanner scannedPin = new Scanner(System.in);
        int pin = scannedPin.nextInt();
        for (Account account : accounts) {
            if (account.getCustomerName().equals(name) && account.getPIN() == pin) {
                loggedInAccount = account;
                accountFound = true;
                break;
            }
        }
        if(!accountFound) System.out.println("Sorry, no account found!");
        else System.out.println("You have been logged in successfully!");
        return loggedInAccount;
    }

    protected static void showStartMenu(){
        while (true){
            int option = readOptionNumberFromConsole();
            if(option == StartMenu.EXIT.getOptionNumber()) System.exit(0);
            else if(option == StartMenu.LOGIN.getOptionNumber()){
                Account account = readCredentials();
                if(account != null){
                    showATMMenu(account);
                }
                else displayStartMenu();
            }
        }
    }
    private static void displayATMMenu(){
        for (ATMMenu atmMenu : ATMMenu.values()){
            System.out.println(atmMenu.getOptionNumber() + " " + atmMenu.getOptionDescription());
        }
    }

    private static void showATMMenu(Account account){
        displayATMMenu();
        while(true){
            int option = readOptionNumberFromConsole();
            if(option == ATMMenu.DISPLAY_CURRENT_BALANCE.getOptionNumber()){
                System.out.println("Your account balance is: " + account.getBalance() + " " + account.getCurrency());
                displayATMMenu();
            }else if(option == ATMMenu.CASH_WITHDRAWAL.getOptionNumber()){
                boolean isNumber = false;
                Scanner scannedAmount = new Scanner(System.in);
                System.out.println("Please enter the amount you want to withdraw: ");
                while (!isNumber){
                    scannedAmount = new Scanner(System.in);
                    if(scannedAmount.hasNextDouble()) isNumber = true;
                    else System.out.println("Please enter a number!");
                }
                double amount = scannedAmount.nextDouble();
                if(amount < account.getBalance()){
                    account.setBalance(account.getBalance() - amount);
                    System.out.println("You withdraw from your account " + amount + " " + account.getCurrency());
                }else System.out.println("Insufficient balance!");
                displayATMMenu();
            }else if(option == ATMMenu.CASH_DEPOSIT.getOptionNumber()){
                System.out.println("Please enter the amount you want to deposit: ");
                Scanner scannedAmount = new Scanner(System.in);
                boolean isNumber = false;
                while (!isNumber){
                    scannedAmount = new Scanner(System.in);
                    if(scannedAmount.hasNextDouble()) isNumber = true;
                    else System.out.println("Please enter a number!");
                }
                double amount = scannedAmount.nextDouble();
                account.setBalance(account.getBalance() + amount);
                System.out.println("You made a deposit of " + amount + " " + account.getCurrency());
                displayATMMenu();
            }else if(option == ATMMenu.CHANGE_PIN.getOptionNumber()){
                System.out.println("Please enter the new PIN");
                int pin;
                int numberOfDigits = 0;
                Scanner scannedPIN = new Scanner(System.in);
                boolean isNumber = false;
                while (!isNumber){
                    scannedPIN = new Scanner(System.in);
                    if(scannedPIN.hasNextInt()) isNumber = true;
                    else System.out.println("Please enter a number!");
                }
                pin = scannedPIN.nextInt();
                while (pin != 0){
                    numberOfDigits ++;
                    pin = pin/10;
                }
                if(numberOfDigits == 4)
                {
                    account.setPIN(scannedPIN.nextInt());
                    System.out.println("You successfully changed your PIN.");
                    displayATMMenu();
                }
               else {
                   System.out.println("Error! The PIN you entered does not have 4 digits!");
                    displayATMMenu();
                }

            }else if(option == ATMMenu.EXIT.getOptionNumber()) {
                displayStartMenu();
                showStartMenu();
            }
        }
    }
}

