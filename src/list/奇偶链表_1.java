package list;

public class 奇偶链表_1 {

    /**
     * 给定单链表的头节点 head ，将所有索引为奇数的节点和索引为偶数的节点分别组合在一起，然后返回重新排序的列表。
     *
     * 第一个节点的索引被认为是 奇数 ， 第二个节点的索引为 偶数 ，以此类推。
     *
     * 请注意，偶数组和奇数组内部的相对顺序应该与输入时保持一致。
     *
     * 你必须在 O(1) 的额外空间复杂度和 O(n) 的时间复杂度下解决这个问题。
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        ListNode dummy1 = new ListNode(-1);
        ListNode head1 = dummy1;

        ListNode dummy2 = new ListNode(-1);
        ListNode head2 = dummy2;

        while (slow != null && fast != null) {
            if (slow.next == null || fast.next == null) {
                break;
            }

            ListNode next1 = slow.next.next;
            ListNode next2 = fast.next.next;

            head1.next = slow;
            head2.next = fast;

            head1 = head1.next;
            head2 = head2.next;

            slow.next = null;
            fast.next = null;

            slow = next1;
            fast = next2;
        }

        if (slow != null) {
            head1.next = slow;

            head1 = slow;

            slow.next = null;
        }

        if (fast != null) {
            head2.next = fast;

            head2 = fast;

            fast.next = null;
        }

        head1.next = dummy2.next;
        return dummy1.next;
    }
}
