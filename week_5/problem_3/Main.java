package week_5.problem_3;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        Account a1 = new Account(1001, 500);
        SavingsAccount a2 = new SavingsAccount(2001, 1000, 0.05);
        CheckingAccount a3 = new CheckingAccount(3001, 200, 10);

        bank.openAccount(a1);
        bank.openAccount(a2);
        bank.openAccount(a3);

        a3.deposit(50);      // 1
        a3.withdraw(20);     // 2
        a3.withdraw(20);     // 3
        a3.withdraw(20);     // 4 

        a1.transfer(100, a2);

        System.out.println("Before update:");
        bank.printAll();

        bank.update();

        System.out.println("After update:");
        bank.printAll();
    }
}