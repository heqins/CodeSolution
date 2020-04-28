public class linked_list_cycle2 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {return null;}
        ListNode fast = head;
        ListNode slow = head;
        ListNode begin = null;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                begin = slow;
                break;
            }
        }
        return begin;
    }

    public ListNode detectCycle2(ListNode head) {
        if (head == null || head.next == null) {return null;}
        ListNode fast = head;
        ListNode slow = head;
        ListNode begin = null;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                break;
            }
        }

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        begin = slow;
        return begin;
    }
}
