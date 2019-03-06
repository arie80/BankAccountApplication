package bankaccountapp;

public class Account implements IBaseRate {
    private String name;
    private String sSn;
    private double balance;
    private static int index = 10000;
    private String accountNumber;
    private double rate;

    public Account(String name, String sSn, double initDeposit) {
        this.name = name;
        this.sSn = sSn;
        this.balance = initDeposit;

        index++;
        setAccountNumber(generateAccounNumber());
        setBaseRate();
    }

    private String generateAccounNumber() {
        String lastTwoSSN = sSn.substring(sSn.length()-2);
        int uniqueID = index;
        int randomNumber = (int) (Math.random() * Math.pow(10, 3));
        return lastTwoSSN + uniqueID + randomNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void showInfo() {
        System.out.println(
                "NAME: " + name +
                "\nACCOUNT NUMBER: " + accountNumber +
                "\nBALANCE: " + balance +
                "\nRATE: " + getRate() + "%"
                );
    }

    public long generateNum(int a, int b) {
        GenerateNumber generateNumber = (c, d) -> (long) (Math.random() * Math.pow(c, d));
        return generateNumber.setNumber(a, b);
    }

    public double getRate() {
        return rate;
    }

    public void setRate (double rate) {
        this.rate = rate;
    }
    
    public void compound() {
        double accruedInterest = balance * (rate/100);
        balance += accruedInterest;
        System.out.println("Accrued Interest: $" + accruedInterest);
        printBalance();
    }

    public void deposit (double amount) {
        balance += amount;
        System.out.println("Depositing $" + amount);
        printBalance();
    }

    public void withdraw (double amount) {
        balance -= amount;
        System.out.println("Withdrawing $" + amount);
        printBalance();
    }

    public void transfer (String toWhere, double amount) {
        balance -= amount;
        System.out.println("Tranfering $" + amount);
        printBalance();
    }

    public void printBalance() {
        System.out.println("Your balance is now: $" + balance);
    }

    @Override
    public void setBaseRate() {
        // TODO Auto-generated method stub
    }
}