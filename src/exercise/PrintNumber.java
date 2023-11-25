package exercise;

public class PrintNumber {

    private int count = 0;

    private final Object LOCK = new Object();

    public static void main(String[] args) {
        PrintNumber printNumber = new PrintNumber();

        new Thread(() -> {
            printNumber.print("A", 0);
        }).start();

        new Thread(() -> {
            printNumber.print("B", 1);
        }).start();
    }

    public void print(String flag, int target) {
        for (int i = 1; i <= 50; i++) {
            synchronized (LOCK) {
                while (count % 2 != target) {
                    try {
                        LOCK.wait();
                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                count++;

                System.out.println(flag + " " + count);

                LOCK.notifyAll();
            }
        }
    }
}
