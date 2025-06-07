import accounts.Account;

import java.rmi.server.UID;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    public String name;
    private String customerId;
    private List<Account> accounts = new ArrayList<>();

    public Customer(String name) {
        this.name =name;
        this.customerId = "1";
    }
    public boolean addAccount(Account account) {
        if (!this.accounts.contains(account)) {
            this.accounts.add(account);
            return true;
        }
        return false;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public String getName() {return this.name; }

    public String getCustomerId() {return this.customerId; }
}
