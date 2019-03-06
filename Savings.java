package bankaccountapp;

public class Savings extends Account {
    private int safetyDepositBoxID;
    private int safetyDepositBoxKey;

    public Savings(String name, String sSn, double initDeposit) {
        super(name, sSn, initDeposit);
        setAccountNumber("1" + getAccountNumber());
        setDepositBox();

    }

    private void setDepositBox() {
        this.safetyDepositBoxID = (int) generateNum(10, 3);
        this.safetyDepositBoxKey = (int) generateNum(10, 4);
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println(
                " Your Savings Account Features" +
                "\n Safety Deposit Box ID: " + this.safetyDepositBoxID +
                "\n Safety Deposit Box Key: " + this.safetyDepositBoxKey
                );
    }

    @Override
    public void setBaseRate() {
        setRate(getBaseRate() - .25);
    }
}