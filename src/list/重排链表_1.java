package list;

public class 重排链表_1 {

    /**
     * 问题：给定一个链表，链表中节点的顺序是L0→L1→L2→...
     * →Ln-1→Ln，请问如何重排链表使节点的顺序变成L0→Ln→L1→Ln-
     * 1→L2→Ln-2→...？例如，输入图4.12（a）中的链表，重排之后的链
     * 表如图4.12（b）所示。
     * @param args
     */

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        reorderList(head);

        System.out.println("test");
    }

    public static void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalf = slow.next;
        ListNode firstHalf = head;
        slow.next= null;

        secondHalf = reverse(secondHalf);

        merge(firstHalf, secondHalf);
    }

    public static ListNode reverse(ListNode head) {
        // 不能用dummy.next返回新的头节点，因为这个时候已经反转了，
        ListNode cur= head;
        ListNode pre = null;

        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }

        return pre;
    }

    public static void merge(ListNode head1, ListNode head2) {
        while (head2 != null) {
            ListNode temp1 = head1.next;
            ListNode temp2 = head2.next;

            head1.next = head2;
            head2.next = temp1;

            head1 = temp1;
            head2 = temp2;
        }
    }
}
