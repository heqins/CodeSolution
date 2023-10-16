package 多线程.transfer;

public class Task implements Runnable{

    private BankAccount bankAccount;

    public Task(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {

            this.transfer(100);

            if (bankAccount.getBalance() == 0) {
                System.out.println("余额不足");
            }else if (bankAccount.getBalance() < 0) {
                System.out.println("账户透支!!");
            }
        }
    }

    public void transfer(int amount) {
        synchronized (this.bankAccount) {
            if (this.bankAccount.getBalance() >= amount) {
                try {
                    Thread.sleep(500);
                }catch (Exception e) {
                }

                this.bankAccount.transfer(amount);
                System.out.println("完成取款 金额:" + amount + " 余额:" + this.bankAccount.getBalance());
            }
        }

    }
}
