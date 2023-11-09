package test;

import java.util.Date;

public class ValueTest {

    public static void main(String[] args) {
        ValueTest valueTest = new ValueTest();
        valueTest.test();

        Date date = new Date(2012,1,1);
        System.out.println(date);
    }

    public void test() {
        int a = 1;
        say(a);

        System.out.println(a);
    }

    public void say(int a) {
        a = a + 1;
    }
}
