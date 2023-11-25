package exercise.transfer;

public class Test {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        Thread t1 = new Thread(new Task(account));
        Thread t2 = new Thread(new Task(account));

        t1.start();
        t2.start();
    }
}
