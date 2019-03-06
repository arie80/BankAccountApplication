package bankaccountapp;

import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {

    public static void main(String[] args) {

        List<Account> accounts = new LinkedList<Account>();
        String file = ("NewBankAccounts.csv");

        List<String[]> newAccountHolders = CSV.read(file);

        // Read a CSV file then create new accounts based on that data
        newAccountHolders.forEach(n -> {
            String name = n[0];
            String sSn = n[1];
            String accountType = n[2];
            double initDeposit = Double.parseDouble(n[3]);
            if (accountType.equalsIgnoreCase("Savings")) {
                accounts.add(new Savings(name, sSn, initDeposit));
            } else if (accountType.equalsIgnoreCase("Checking")) {
                accounts.add(new Checking(name, sSn, initDeposit));
            } else {
                System.out.println("ERROR READING ACCOUNT TYPE");
            }
        });

        accounts.forEach(s -> {
            System.out.println("**************");
            s.showInfo();
        });

        //// Depositing random account
        // int range = (accounts.size() - 1) + 1;
        // accounts.get((int) (Math.random() * range)).deposit(10000);
        //// Withdrawing random account
        // accounts.get((int) (Math.random() * range)).withdraw(500);
    }
}