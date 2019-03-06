package bankaccountapp;

public interface IBaseRate {

    public void setBaseRate();

    public default double getBaseRate() {
        return 2.5;
    }
}