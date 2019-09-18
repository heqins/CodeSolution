package DataStructure;

public class yingyong_02_10 {
    public int ackermann(int m, int n) {
        return ack(m, n);
    }

    public int ack(int m, int n) {
        if (m == 0) {
            return n + 1;
        }else if (n == 0) {
            return ack(m - 1, 1);
        }else {
            return ack(m - 1, ack(m, n - 1));
        }
    }

    public int ack2(int m, int n) {
        if (m == 0) {
            return n + 1;
        }else if (n == 0) {

        }
        return 0;
    }

    public static void main(String[] args) {
        yingyong_02_10 y0210 = new yingyong_02_10();
        System.out.println(y0210.ackermann(2, 0));
    }
}
