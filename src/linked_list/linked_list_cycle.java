/**
Given a linked list, determine if it has a cycle in it.

To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list

where tail connects to. If pos is -1, then there is no cycle in the linked list.
**/

/**
 快慢针。快针每次都两步，慢针每次走一步。如果无环，快针肯定会率先到达队尾，
 即遇到None。如果有环，快针永远无法遇到None，并且会与慢针相遇。
 */

public class linked_list_cycle {
    public boolean hasCycle(ListNode head) {
        if(head == null) {
            return false;
        }
        ListNode fast = head, slow = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                return true;
            }
        }
        return false;
    }
}
