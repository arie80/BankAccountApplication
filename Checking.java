package bankaccountapp;

public class Checking extends Account {
    private long debitCardNumber;
    private int debitCardPIN;

    public Checking(String name, String sSn, double initDeposit) {
        super(name, sSn, initDeposit);
        setAccountNumber("2" + getAccountNumber());
        setDebitCard();
    }

    private void setDebitCard() {
        this.debitCardNumber = generateNum(10, 12);
        this.debitCardPIN = (int) generateNum(10, 4);
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println(
                " Your Checking Account Features" +
                "\n Debit Card Number: " + this.debitCardNumber +
                "\n Debit Card PIN: " + this.debitCardPIN
                );
    }

    @Override
    public void setBaseRate() {
        setRate(getBaseRate() * .15);
    }
}