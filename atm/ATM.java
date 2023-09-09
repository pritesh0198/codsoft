package java4;

public class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void withdraw(double amount) {
        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful. Your new balance is: " + account.checkBalance());
        } else {
            System.out.println("Insufficient funds. Your current balance is: " + account.checkBalance());
        }
    }

    public void deposit(double amount) {
        account.deposit(amount);
        System.out.println("Deposit successful. Your new balance is: " + account.checkBalance());
    }

    public void checkBalance() {
        System.out.println("Your current balance is: " + account.checkBalance());
    }
}
