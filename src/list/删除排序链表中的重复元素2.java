package list;

public class 删除排序链表中的重复元素2 {

    /**
     * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;

        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                // 关键就是这里要记录当前重复值并跳过
                int duplicate = cur.next.val;
                while (cur.next != null && cur.next.val == duplicate) {
                    cur.next = cur.next.next;
                }
            }else {
                cur = cur.next;
            }
        }

        return dummy.next;
    }
}
