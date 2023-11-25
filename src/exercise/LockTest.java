package exercise;

public class LockTest {

    public synchronized static String getTest() throws Exception{
        System.out.println("test");
        Thread.sleep(300000);
        return "test";
    }

    public synchronized String getTest2() throws Exception{
        System.out.println("test2");
        Thread.sleep(300000);
        return "test2";
    }

    public static void main(String[] args) throws Exception{
        new Thread(() -> {
            LockTest test = new LockTest();
            try {
                test.getTest2();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        new Thread(() -> {
            LockTest test = new LockTest();
            try {
                test.getTest2();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

    }
}
