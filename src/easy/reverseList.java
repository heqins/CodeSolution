package easy;

public class reverseList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;

        /**
         * Complexity analysis
         *
         * Time complexity : O(n)O(n). Assume that nn is the list's length, the time complexity is O(n)O(n).
         *
         * Space complexity : O(1)O(1).
         */

        /**
         * public ListNode reverseList(ListNode head) {
         *     if (head == null || head.next == null) return head;
         *     ListNode p = reverseList(head.next);
         *     head.next.next = head;
         *     head.next = null;
         *     return p;
         * }
         *
         * Time complexity : O(n)O(n). Assume that nn is the list's length, the time complexity is O(n)O(n).
         *
         * Space complexity : O(n)O(n). The extra space comes from implicit stack space due to recursion.
         * The recursion could go up to nn levels deep.
         */
    }
}
