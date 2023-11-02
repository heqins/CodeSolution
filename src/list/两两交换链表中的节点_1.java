package list;

public class 两两交换链表中的节点_1 {

    /**
     * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode();

        // 从要交换的区间前一个开始
        dummy.next = head;
        ListNode fast = dummy;

        while (fast != null && fast.next != null && fast.next.next != null) {
            ListNode start = fast.next;

            ListNode end = fast.next.next;

            start.next = end.next;

            end.next = start;

            fast.next = end;

            fast = start;
        }

        return dummy.next;
    }

    public ListNode swapPairs2(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;

        ListNode slow = head;
        if (head == null) {
            return head;
        }

        ListNode fast = slow.next;

        while (fast != null) {
            ListNode temp = fast.next;

            cur.next = fast;
            fast.next = slow;
            slow.next = temp;

            cur = slow;
            slow = temp;

            if (slow == null) {
                break;
            }

            fast = slow.next;
        }

        return dummy.next;
    }
}
