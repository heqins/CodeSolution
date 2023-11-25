package exercise.transfer;

public class TestBank implements Runnable{

    private BankAccount account;

    static class BankAccount {
        private int balance;


        public BankAccount(int balance) {
            this.balance = balance;
        }

        public void transfer(int amount) {
            this.balance -= amount;
        }

        public void save(int amount) {
            this.balance += amount;
        }

        public int getBalance() {
            return this.balance;
        }
    }

    public TestBank(BankAccount bankAccount) {
        this.account = bankAccount;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {

            this.myTransfer(100);

            if (this.account.getBalance() == 0) {
                System.out.println("余额不足");
            }else if (this.account.getBalance() < 0) {
                System.out.println("透支了");
            }
        }
    }

    public void myTransfer(int amount) {
        synchronized (this.account) {
            if (this.account.getBalance() >= amount) {
                try {
                    Thread.sleep(500);
                }catch (InterruptedException ie) {
                    ie.printStackTrace();
                }

                System.out.println("转账了: " + amount + " 余额为: " + this.account.getBalance());

                this.account.transfer(amount);
            }
        }
    }

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(500);

        Thread t1 = new Thread(new TestBank(bankAccount));

        Thread t2 = new Thread(new TestBank(bankAccount));

        t1.start();

        t2.start();
    }
}
