package DataStructure;

public class yingyong_01_07 {
    public static double cal(Node h1, int x) {
        double sum = h1.coef * Math.pow(x, h1.exp);
        Node p = h1.next;

        while (p != h1) {
            sum += p.coef * Math.pow(x, p.exp);
            p = p.next;
        }

        return sum;
    }

    public static void main(String[] args) {
        Node h1 = new Node();
        h1.coef = 2;
        h1.exp = 2;
        Node h2 = new Node();
        h2.coef = 3;
        h2.exp = 1;
        h1.next = h2;
        h2.next = h1;
        System.out.println(cal(h1, 3));
    }
}
