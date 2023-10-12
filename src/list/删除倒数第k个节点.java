package list;

public class 删除倒数第k个节点 {

    /**
     * 题目：如果给定一个链表，请问如何删除链表中的倒数第k个节
     * 点？假设链表中节点的总数为n，那么1≤k≤n。要求只能遍历链表
     * 一次。
     */
    public ListNode deleteKthNode(ListNode head, int k) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode left = dummy, right = head;
        for (int i = 0; i < k; i++) {
            right = right.next;
        }

        while (right != null) {
            right = right.next;
            left = left.next;
        }

        left.next = left.next.next;
        return dummy.next;
    }
}
