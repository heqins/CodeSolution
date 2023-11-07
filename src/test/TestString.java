package test;

public class TestString {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        String t1 = "t";
        for (int i = 0; i < 1000000; i++) {
            t1 += i;
        }
        System.out.println("耗时1: " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        sb.append("t");

        for (int i = 0; i < 1000000; i++) {
            sb.append(i);
        }
        System.out.println("耗时2: " + (System.currentTimeMillis() - start));
    }
}
