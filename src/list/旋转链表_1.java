package list;

public class 旋转链表_1 {

    /**
     * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        if (k == 0) {
            return head;
        }

        int length = getLength(head);
        int target = k % length;
        if (target == 0) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        for (int i = 0; i < target; i++) {
            if (fast == null) {
                break;
            }

            fast = fast.next;
        }

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        ListNode newHead = slow.next;
        slow.next = null;

        fast.next = head;

        return newHead;
    }

    public int getLength(ListNode head) {
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            count++;
        }

        return count;
    }
}
