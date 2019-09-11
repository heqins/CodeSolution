package DataStructure;

public class yingyong_01_10 {
    public static ListNode merge(ListNode head1, ListNode head2) {
        ListNode p1 = head1;
        ListNode p2 = head2;
        ListNode h3;
        ListNode p3;

        if (p1.val <= p2.val) {
            h3 = p1;
            p1 = p1.next;
            h3.next = null;
        }else {
            h3 = p2;
            p2 = p2.next;
            h3.next = null;
        }

        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                p3 = p1;
                p1 = p1.next;
                p3.next = h3;
                h3 = p3;
            }else {
                p3 = p2;
                p2 = p2.next;
                p3.next = h3;
                h3 = p3;
            }
        }

        while (p1 != null) {
            p3 = p1;
            p1 = p1.next;
            p3.next = h3;
            h3 = p3;
        }

        while (p2 != null) {
            p3 = p2;
            p2 = p2.next;
            p3.next = h3;
            h3 = p3;
        }
        return h3;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode head2 = new ListNode(1);
        ListNode b2 = new ListNode(2);
        head1.next = a2;
        a2.next = a3;
        head2.next = b2;
        System.out.println(merge(head1, head2));
    }
}
