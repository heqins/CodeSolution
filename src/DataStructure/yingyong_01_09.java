package DataStructure;

public class yingyong_01_09 {
    public static void locate(DualNode head, int x) {
        DualNode p = head.next;

        while (p.data != x) {
            if (p == head) return;
            p = p.next;
        }

        p.freq += 1;

        while (p.freq > p.prior.freq && p.prior != head) {
            p.prior.prior.next = p;
            p.prior = p.prior.prior;
            p.prior.next = p.next;
            p.next = p.prior;
            p.next.prior = p.prior;
            p.prior.prior = p;
        }
    }

    public static void main(String[] args) {
        DualNode head = new DualNode(-1);
        DualNode h2 = new DualNode(2);
        DualNode h3 = new DualNode(3);
        DualNode h4 = new DualNode(4);
        head.prior = h3;
        h3.next = head;
        head.next = h2;
        h2.prior = head;
        h2.next = h3;
        h3.prior = h2;
        h3.next = h4;
        h4.prior = h3;
        h4.next = head;
        locate(head, 4);
        locate(head, 3);
        System.out.println(head.data);
        System.out.println(head.next.data);
        System.out.println(head.next.next.data);

    }
}
