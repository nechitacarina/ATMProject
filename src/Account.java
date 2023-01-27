public class Account {
    private final String customerName;
    private int PIN;
    private final char currency;
    private double balance;
    Account(String customerName, int PIN, char currency, double balance){
        this.customerName = customerName;
        this.PIN = PIN;
        this.currency = currency;
        this.balance = balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getPIN() {
        return PIN;
    }

    public void setPIN(int PIN) {
        this.PIN = PIN;
    }

    public char getCurrency() {
        return currency;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
