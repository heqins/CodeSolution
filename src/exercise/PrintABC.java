package exercise;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class PrintABC {

    private static AtomicInteger count = new AtomicInteger(0);


    public static class Task implements Runnable {

        private Semaphore current;

        private Semaphore next;

        private String name;

        public Task(String name, Semaphore current, Semaphore next) {
            this.current = current;
            this.next = next;
            this.name = name;
        }

        @Override
        public void run() {
            for (int i = 0; i < 500; ) {
                try {
                    current.acquire(1);

                    System.out.println("Thread " + name + " num: " + count.addAndGet(1));

                    i++;

                    next.release(1);
                }catch (Exception e) {

                }
            }
        }
    }
    public static void main(String[] args) {
        Semaphore semaphore1 = new Semaphore(1);

        Semaphore semaphore2 = new Semaphore(0);

        Semaphore semaphore3 = new Semaphore(0);

        Thread thread1 = new Thread(new Task("A", semaphore1, semaphore2));

        Thread thread2 = new Thread(new Task("B", semaphore2, semaphore3));

        Thread thread3 = new Thread(new Task("C", semaphore3, semaphore1));

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
