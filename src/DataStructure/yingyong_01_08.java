package DataStructure;

public class yingyong_01_08 {
    public static Node derivative(Node head) {
        if (head.next == null) {return head;}

        Node p = head;
        Node q = head.next;

        while (q != head) {
            if (q.exp == 0) {
                p.next = q.next;
                q = p.next;
            }else {
                q.coef = q.coef * q.exp;
                q.exp--;
                p = q;
                q = q.next;
            }
        }

        if (q.exp == 0) {
            p.next = q.next;
            head = p.next;
        }else {
            q.coef = q.coef * q.exp;
            q.exp--;
        }

        return head;
    }

    public static void main(String[] args) {
        Node h1 = new Node();
        h1.coef = 2;
        h1.exp = 3;
        Node h2 = new Node();
        h2.coef = -3;
        h2.exp = 1;
        h1.next = h1;
        h2.next = h1;
        derivative(h1);
        System.out.println(h1.coef);
        System.out.println(h1.exp);
    }
}
