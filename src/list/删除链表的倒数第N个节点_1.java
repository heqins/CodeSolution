package list;

public class 删除链表的倒数第N个节点_1 {

    /**
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n == 0) {
            return head;
        }

        ListNode dummy = new ListNode();
        dummy.next = head;

        // todo: 从dummy开始
        ListNode slow = dummy;
        ListNode fast = dummy;

        int count = 0;

        while (count < n) {
            fast = fast.next;
            count++;

            if (fast == null) {
                break;
            }
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }
}
