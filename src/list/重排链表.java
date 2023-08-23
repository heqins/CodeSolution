package list;

import java.util.List;

public class 重排链表 {

    /**
     * 问题：给定一个链表，链表中节点的顺序是L0→L1→L2→...
     * →Ln-1→Ln，请问如何重排链表使节点的顺序变成L0→Ln→L1→Ln-
     * 1→L2→Ln-2→...？例如，输入图4.12（a）中的链表，重排之后的链
     * 表如图4.12（b）所示。
     * @param args
     */
    public static void main(String[] args) {

    }

    public static void reorderList(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;
        while (slow != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }

        ListNode temp = slow.next;
        slow.next = null;
        link(head, reverse(temp), dummy);
    }

    private static void link(ListNode node1, ListNode node2, ListNode head) {


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
