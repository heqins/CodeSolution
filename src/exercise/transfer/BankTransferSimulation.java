package exercise.transfer;

public class BankTransferSimulation {

    public static class Account {
        private int balance;

        public Account(int balance) {
            this.balance = balance;
        }

        public int getBalance() {
            return balance;
        }

        public void deposit(int amount) {
            balance += amount;
        }

        public void withdraw(int amount) {
            balance -= amount;
        }
    }

    public static void transfer(Account from, Account to, int amount) {
        synchronized (from) {
            synchronized (to) {
                if (from.getBalance() >= amount) {
                    from.withdraw(amount);
                    to.deposit(amount);
                    System.out.println(Thread.currentThread().getName() + " transferred " + amount + " from Account " + from + " to Account " + to);
                } else {
                    System.out.println(Thread.currentThread().getName() + " failed to transfer " + amount + " from Account " + from + " to Account " + to);
                }
            }
        }
    }

    public static void main(String[] args) {
        Account account1 = new Account(1000);
        Account account2 = new Account(1500);

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                transfer(account1, account2, 100);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                transfer(account2, account1, 50);
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final balance in Account 1: " + account1.getBalance());
        System.out.println("Final balance in Account 2: " + account2.getBalance());
    }
}
