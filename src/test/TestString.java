package test;

public class TestString {

    private volatile int a;

    public void update() {
        a = 1;
    }
    public static void main(String[] args) {
        TestString test = new TestString();
        test.update();
    }
}
