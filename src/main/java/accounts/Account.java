package accounts;

public abstract class Account {
    protected String accountNumber;
    protected int balance;
    public abstract void displayInfo();

    public Account() {
        accountNumber = "1";
    }
     public boolean deposit(int amountInCents) {
        this.balance += amountInCents;
        return true;
    }

    public boolean withdraw(int amountInCents) {
        if (this.balance >= amountInCents) {
            this.balance -= amountInCents;
            return true;
        }
        return false;
    }

    public int getBalance() {return balance; }

    public String getAccountNumber() {return accountNumber; }
}
