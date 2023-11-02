package list;

public class 删除链表中的重复元素_1 {

    /**
     * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode cur = head;

        while (cur != null && cur.next != null) {
            if (cur.next.val != cur.val) {
                cur = cur.next;
            }else {
                ListNode next = cur.next.next;
                cur.next.next = null;
                cur.next = next;
            }
        }

        return head;
    }
}
