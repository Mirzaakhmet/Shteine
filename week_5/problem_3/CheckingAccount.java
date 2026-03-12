package week_5.problem_3;

public class CheckingAccount extends Account {
    public static final int FREE_TRANSACTIONS = 3;

    private double fee;
    private int transactionCount = 0;

    public CheckingAccount(int accNumber, double initialBalance, double fee) {
        super(accNumber, initialBalance);
        this.fee = fee;
    }

    private void chargeIfNeeded() {
        transactionCount++;
        if (transactionCount > FREE_TRANSACTIONS) {
            if (getBalance() >= fee) {
                setBalance(getBalance() - fee);
            } else {
                setBalance(0);
            }
        }
    }

    @Override
    public void deposit(double amount) {
        if (amount <= 0) return;
        super.deposit(amount);
        chargeIfNeeded();
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount <= 0) return false;

        boolean ok = super.withdraw(amount);
        if (ok) chargeIfNeeded();

        return ok;
    }

    @Override
    public boolean transfer(double amount, Account other) {
        boolean ok = super.transfer(amount, other);
        if (ok) chargeIfNeeded();
        return ok;
    }

    @Override
    public String toString() {
        return "CheckingAccount{" +
                "accNumber=" + getAccountNumber() +
                ", balance=" + getBalance() +
                ", fee=" + fee +
                ", transactionCount=" + transactionCount +
                '}';
    }
}