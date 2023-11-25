package exercise;

import java.util.concurrent.locks.ReentrantLock;

public class T {

    private int times;

    private int state = 0;

    private final ReentrantLock lock = new ReentrantLock();

    public T(int times) {
        this.times = times;
    }

    public void run(String name, int targetState) {
        for (int i = 1; i <= times; ) {
           lock.lock();
           try {
               if (state % 3 == targetState) {
                   state += 1;

                   i++;

                   System.out.println(name + ": " + state);
               }
           }finally {
               lock.unlock();
           }
        }
    }

    public static void main(String[] args) {
        T t = new T(333);

        new Thread(() -> {
            t.run("A", 0);
        }).start();

        new Thread(() -> {
            t.run("B", 1);
        }).start();

        new Thread(() -> {
            t.run("C", 2);
        }).start();


    }
}
