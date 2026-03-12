package week_5.problem_3;

import java.util.Vector;

public class Bank {
    private Vector<Account> accounts = new Vector<>();

    public void openAccount(Account a) {
        if (a == null) return;
        accounts.add(a);
    }

    public boolean closeAccount(int accNumber) {
        Account a = find(accNumber);
        if (a == null) return false;
        accounts.remove(a);
        return true;
    }

    public Account find(int accNumber) {
        for (Account a : accounts) {
            if (a.getAccountNumber() == accNumber) return a;
        }
        return null;
    }

    public void update() {
        for (Account a : accounts) {
            a.update();
        }
    }

    public void printAll() {
        for (Account a : accounts) {
            System.out.println(a);
        }
    }
}