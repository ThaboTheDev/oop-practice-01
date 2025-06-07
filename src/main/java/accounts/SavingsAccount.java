package accounts;

public class SavingsAccount extends Account{

    @Override
    public void displayInfo() {
        System.out.println("Account Type : Savings Account.");
        System.out.println("Balance:" + getBalance());
        System.out.println("AccountNumber:" + getAccountNumber());
    }

    public SavingsAccount() {
        super();
    }
}
