package exercise;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class 三个线程交替打印 {

    private static final Integer MAX = 1000;

    private static Semaphore semaphore1 = new Semaphore(1);

    private static Semaphore semaphore2 = new Semaphore(0);

    private static Semaphore semaphore3 = new Semaphore(0);

    private static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) {

        Thread thread1 = new Thread(new Task("A", semaphore1, semaphore2));

        Thread thread2 = new Thread(new Task("B", semaphore2, semaphore3));

        Thread thread3 = new Thread(new Task("C", semaphore3, semaphore1));

        thread1.start();
        thread2.start();
        thread3.start();
    }

    public static class Task implements Runnable {

        private Semaphore semaphore;

        private Semaphore next;

        private String holder;

        public Task(String holder, Semaphore semaphore, Semaphore next) {
            this.semaphore = semaphore;
            this.next =  next;
            this.holder = holder;
        }

        @Override
        public void run() {

            while (true) {
                try {
                    semaphore.acquire();

                    if (count.get() >= MAX) {
                        System.exit(0);
                    }

                    System.out.println("Thread " + holder + " print current:" + (count.addAndGet(1)));
                    next.release();
                } catch (Exception e) {
                }
            }
        }
    }

}
