/**
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.

Note: Do not modify the linked list.
**/

/**
这个求单链表中的环的起始点是之前那个判断单链表中是否有环的延伸，可参之前那道 Linked List Cycle。这里还是要设快慢指针，

不过这次要记录两个指针相遇的位置，当两个指针相遇了后，让其中一个指针从链表头开始，一步两步，一步一步似爪牙，

似魔鬼的步伐。。。哈哈，打住打住。。。此时再相遇的位置就是链表中环的起始位置，为啥是这样呢，这里直接贴上热心网友「飞鸟想飞」的解释哈，

因为快指针每次走2，慢指针每次走1，快指针走的距离是慢指针的两倍。而快指针又比慢指针多走了一圈。

所以 head 到环的起点+环的起点到他们相遇的点的距离 与 环一圈的距离相等。现在重新开始，head 运行到环起点 和 相遇点到环起点 的距离也是相等的，

相当于他们同时减掉了 环的起点到他们相遇的点的距离。代码如下：
**/


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
