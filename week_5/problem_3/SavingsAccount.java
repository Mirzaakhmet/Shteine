package week_5.problem_3;

public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(int accNumber, double initialBalance, double interestRate) {
        super(accNumber, initialBalance);
        this.interestRate = interestRate;
    }

    public void addInterest() {
        double newBalance = getBalance() * (1 + interestRate);
        setBalance(newBalance);
    }

    @Override
    public void update() {
        addInterest();
    }

    @Override
    public String toString() {
        return "SavingsAccount{" +
                "accNumber=" + getAccountNumber() +
                ", balance=" + getBalance() +
                ", interestRate=" + interestRate +
                '}';
    }
}