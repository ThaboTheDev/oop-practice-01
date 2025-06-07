import java.util.List;
import java.util.Scanner;

public class Main {
    static public Scanner scanner = new Scanner(System.in);
    static private List<String> list = List.of("1", "2", "3", "4", "5", "6", "7");

    public static void main(String[] args) {
        while (true) {
            System.out.println("""
                    ===== Banking Menu =====
                    1. Create Customer
                    2. Create Account
                    3. Deposit
                    4. Withdraw
                    5. Transfer
                    6. View Account Info
                    7. Exit
                    """);

//            String input = scanner.nextLine().trim();
//            if (input.isEmpty()) {
//                System.out.println("Input must not be empty");
//                continue;
//            }
//
//            if (!list.contains(input)) {
//                System.out.println(input + " is an incorrect input");
//                continue;
//            }

            BankingService bankingService = new BankingService();
            Customer customer = bankingService.createCustomer("thabo");
            bankingService.createAccount(customer.getCustomerId(), "savings");
            String accountNumber = customer.getAccounts().getFirst().getAccountNumber();
            bankingService.deposit(customer.getCustomerId(), accountNumber, 100000);
            bankingService.printCustomerAccount(customer.getCustomerId());
            bankingService.withdraw(customer.getCustomerId(), accountNumber, 500);
            bankingService.printCustomerAccount(customer.getCustomerId());
            break;
        }
    }
}
