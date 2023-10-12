package list;

public class 分隔链表 {

    /**
     * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
     * 你应当 保留 两个分区中每个节点的初始相对位置。
     */
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);

        ListNode node = head;

        ListNode start1 = dummy1;
        ListNode start2 = dummy2;

        while (node != null) {
            ListNode temp = new ListNode(node.val);
            if (temp.val < x) {
                start1.next = temp;
                start1 = temp;
            }else {
                start2.next = temp;
                start2 = temp;
            }

            node = node.next;
        }

        start1.next = dummy2.next;

        return dummy1.next;
    }
}
