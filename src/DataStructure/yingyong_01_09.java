package DataStructure;

public class yingyong_01_09 {
    public static void locate(DualNode head, int x) {
        DualNode p = head.next;
        DualNode q;
        while (p != null && p.data != x) {
            p = p.next;
        }
        if (p == null) {
            System.out.println("不存在值为" + x + "的结点!");
        }else {
            p.freq++;
            q = p.prior;
            while (q != head && q.freq < p.freq) {
                q = q.prior;
            }
            if (q != p.prior) {
                p.prior.next = p.next;
                if (p.next != null) {
                    p.next.prior = p.prior;
                }
                p.prior = q;
                p.next = q.next;
                q.next = p;
                p.next.prior = p;
            }
        }
    }

    public static void main(String[] args) {
        DualNode head = new DualNode(-1);
        DualNode h2 = new DualNode(2);
        DualNode h3 = new DualNode(4);
        DualNode h4 = new DualNode(5);
        head.next = h2;
        h2.prior = head;
        h2.next = h3;
        h3.prior = h2;
        h3.next = h4;
        h4.prior = h3;
        locate(head, 4);
        locate(head, 5);
        locate(head, 6);
//        System.out.println(head.next.data);
//        System.out.println(head.data);
//        System.out.println(head.next.data);
//        System.out.println(head.next.next.data);
    }
}
