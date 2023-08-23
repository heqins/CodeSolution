package list;

public class 链表中的数字相加 {

    /**
     * 题目：给定两个表示非负整数的单向链表，请问如何实现这两
     * 个整数的相加并且把它们的和仍然用单向链表表示？链表中的每个
     * 节点表示整数十进制的一位，并且头节点对应整数的最高位数而尾
     * 节点对应整数的个位数。例如，在图4.10（a）和图4.10（b）中，
     * 两个链表分别表示整数123和531，它们的和为654，对应的链表如图
     * 4.10（c）所示。
     * @param args
     */
    public static void main(String[] args) {

    }

    public static ListNode add(ListNode l1, ListNode l2) {
        ListNode r1 = reverse(l1);
        ListNode r2 = reverse(l2);

        ListNode dummy = new ListNode(0);
        ListNode start = dummy;
        int carry = 0;

        while (r1 != null || r2 != null) {
            int sum = (r1 == null ? 0 : r1.val) + (r2 == null ? 0 : r2.val) + carry;
            carry = sum > 9 ? 1 : 0;
            sum = sum > 9 ? sum - 9 : sum;

            ListNode temp = new ListNode(sum);

            start.next = temp;
            start = start.next;

            r1 = r1 == null ? null : r1.next;
            r2 = r2 == null ? null : r2.next;
        }

        if (carry > 0) {
            start.next = new ListNode(carry);
        }

        return dummy.next;
    }

    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;

            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }
}
