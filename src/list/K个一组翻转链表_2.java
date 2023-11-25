package list;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class K个一组翻转链表_2 {

    /**
     * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
     *
     * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
     *
     * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
     */
    public static void main(String[] args) {
        BigDecimal a = new BigDecimal("1.0");
        BigDecimal b = new BigDecimal("3.0");
        BigDecimal c = a.divide(b, RoundingMode.DOWN);
        System.out.println(c.toString());
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }

        int len = getLength(head);
        if (len < k) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        ListNode pre = dummy;

        while (len >= k) {
            for (int i = 0; i < k; i++) {
                cur = cur.next;
            }

            if (cur == null) {
                break;
            }

            ListNode next = cur.next;

            cur.next = null;

            ListNode start = pre.next;

            // last = 2 pre = dummy
            ListNode last = reverse(pre.next);

            //这里的last指的其实是翻转前的最后一个节点
            pre.next = last;

            start.next = next;

            cur = start;

            pre = start;

            len -= k;
        }

        // 因为dummy.next = head; 所以后面链表翻转后只要用dummy.next就可以把第一组链表的起点拿到
        return dummy.next;
    }

    public ListNode reverse(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;

            cur = next;
        }

        return pre;
    }

    public int getLength(ListNode head) {
        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }

        return count;
    }
}
