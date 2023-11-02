package list;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class K个一组翻转链表 {

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
        if (head == null) {
            return head;
        }

        int length = getLength(head);
        if (length < k) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        // pre是要翻转区间的前一个
        ListNode pre = dummy;

        while (length >= k) {
            ListNode cur = pre.next;
            ListNode nextStart = cur;

            for (int i = 1; i < k; i++) {
                ListNode temp = cur.next;
                // cur的Next指针需要在翻转过程中一直更新
                cur.next = temp.next;
                // 变得是pre.next
                // pre本身不变，pre.next指向要翻转的那个节点的前面
                // 要翻转的就是temp(cur.next),但cur本身不用变，cur.next指针变
                temp.next = pre.next;
                pre.next = temp;
            }

            pre = nextStart;
            length -= k;
        }

        return dummy.next;
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
