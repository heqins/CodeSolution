package list;

public class 两数相加 {
    /**
     * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
     *
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     *
     * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode();
        ListNode head = dummy;

        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            carry = sum / 10;
            sum = sum % 10;

            ListNode temp = new ListNode(sum);

            l1 = l1.next;
            l2 = l2.next;

            head.next = temp;
            head = temp;
        }

        while (l1 != null) {
            int sum = l1.val + carry;
            carry = sum / 10;
            sum = sum % 10;

            ListNode temp = new ListNode(sum);
            l1 = l1.next;
            head.next =temp;
            head = temp;
        }

        while (l2 != null) {
            int sum = l2.val + carry;
            carry = sum / 10;
            sum = sum % 10;

            l2 = l2.next;

            ListNode temp = new ListNode(sum);

            head.next =temp;
            head = temp;
        }

        // 同样的，最后的进位要处理
        if (carry != 0) {
            ListNode temp = new ListNode(carry);
            head.next = temp;
        }

        return dummy.next;
    }
}
