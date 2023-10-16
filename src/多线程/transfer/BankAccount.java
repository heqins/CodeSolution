package 多线程.transfer;

public class BankAccount {

    public void setBalance(int balance) {
        this.balance = balance;
    }

    private int balance = 500;

    public int getBalance() {
        return this.balance;
    }

    public void transfer(int amount) {
        balance -= amount;
    }

    public void save(int amount) {
        this.balance += amount;
    }
}
