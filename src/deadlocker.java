public class deadlocker implements Runnable{
    private int flag = 0;
    static Object o1 = new Object();
    static Object o2 = new Object();
    @Override
    public void run() {
        if(flag == 0) {
            synchronized(o1) {
                try {
                    System.out.println("o1");
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (o2) {
                    System.out.println("0");
                }
            }
        }else if(flag == 1){
            synchronized (o2) {
                try {
                    System.out.println("o2");
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (o1) {
                    System.out.println("1");
                }
            }
        }
    }

    public static void main(String[] args) {
        deadlocker dl1 = new deadlocker();
        deadlocker dl2 = new deadlocker();
        dl1.flag = 0;
        dl2.flag = 1;
        Thread t1 = new Thread(dl1);
        Thread t2 = new Thread(dl2);
        t1.start();
        t2.start();
    }
}
