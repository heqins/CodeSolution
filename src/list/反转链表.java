package list;

public class 反转链表 {

    /**
     * 题目：定义一个函数，输入一个链表的头节点，反转该链表并
     * 输出反转后链表的头节点。例如，把图4.8（a）中的链表反转之后
     * 得到的链表如图4.8（b）所示
     * @param args
     */
    public static ListNode reverseListNode(ListNode head) {
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
