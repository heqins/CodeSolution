package list;

public class 回文链表 {

    /**
     * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
     */
    public boolean isPalindrome(ListNode head) {
        ListNode dummy = head;
        ListNode mid = findMiddle(head);

        if (mid == null) {
            return false;
        }

        ListNode newHead = reverseList(mid);

        while (newHead != null && dummy != null) {
            if (newHead.val != dummy.val) {
                return false;
            }

            if (newHead == null || dummy == null) {
                return false;
            }

            newHead = newHead.next;
            dummy = dummy.next;
        }

        return true;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;

            cur.next = pre;
            pre = cur;
            cur = next;

        }

        return pre;
    }

    public ListNode findMiddle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}
