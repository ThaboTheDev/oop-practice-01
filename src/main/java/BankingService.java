import accounts.Account;
import accounts.CheckingAccount;
import accounts.SavingsAccount;

import java.util.ArrayList;
import java.util.List;

public class BankingService {

    List<Customer> customers = new ArrayList<>();
    public Customer createCustomer(String name) {
        try {
            Customer newCustomer = new Customer(name);
            customers.add(newCustomer);
            return newCustomer;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public boolean createAccount(String customerId, String type) {
        try {
            for (Customer customer : customers) {
                if (customer.getCustomerId().equals(customerId)) {
                    type = type.toLowerCase();
                    if (type.equals("savings")) {
                        customer.addAccount(new SavingsAccount());
                    } else if (type.equals("checking")) {
                        customer.addAccount(new CheckingAccount());
                    }
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public boolean deposit(String customerId, String accountNumber, int amountInCents) {
        try {
            for (Customer customer : customers) {
                if (customer.getCustomerId().equals(customerId)) {
                    for (Account account : customer.getAccounts()) {
                        if (account.getAccountNumber().equals(accountNumber)) {
                            account.deposit(amountInCents);
                            return true;
                        }
                    }
                }
            }
            return false;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public boolean withdraw(String customerId, String accountNumber, int amountInCents) {
        try {
            for (Customer customer : customers) {
                if (customer.getCustomerId().equals(customerId)) {
                    for (Account account : customer.getAccounts()) {
                        if (account.getAccountNumber().equals(accountNumber)) {
                            account.withdraw(amountInCents);
                            return true;
                        }
                    }
                }
            }
            return false;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
