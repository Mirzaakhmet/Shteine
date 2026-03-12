package week_5.problem_3;

public class Account {
    private double balance;
    private int accNumber;

    public Account(int accNumber, double initialBalance) {
        this.accNumber = accNumber;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount <= 0) return;
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) return false;
        if (amount > balance) return false;
        balance -= amount;
        return true;
    }

    public double getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accNumber;
    }

    protected void setBalance(double newBalance) {
        this.balance = newBalance;
    }

    public boolean transfer(double amount, Account other) {
        if (other == null) return false;
        if (this.withdraw(amount)) {
            other.deposit(amount);
            return true;
        }
        return false;
    }

    public void update() {
    }

    @Override
    public String toString() {
        return "Account{" +
                "accNumber=" + accNumber +
                ", balance=" + balance +
                '}';
    }
}