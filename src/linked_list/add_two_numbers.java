/**
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
**/
public class add_two_numbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        if (l1 == null) {
            return null;
        }
        if (l2 == null) {
            return null;
        }

        int carry = 0;
        while (l1 != null && l2 != null) {
            ListNode temp = new ListNode((l1.val + l2.val + carry) % 10);
            // 判断是否进位
            carry = (l1.val + l2.val + carry) / 10;
            curr.next = temp;
            l1 = l1.next;
            l2 = l2.next;
            curr = curr.next;
        }
        while (l1 != null) {
            ListNode temp = new ListNode((l1.val + carry) % 10);
            // 单链依然有可能要进位
            carry = (l1.val + carry) / 10;
            curr.next = temp;
            l1 = l1.next;
            curr = curr.next;
        }
        while (l2 != null) {
            ListNode temp = new ListNode((l2.val + carry) % 10);
            carry = (l2.val + carry) / 10;
            curr.next = temp;
            l2 = l2.next;
            curr = curr.next;
        }
        if (carry == 1) {
            ListNode temp = new ListNode(1);
            curr.next = temp;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {

    }
}
