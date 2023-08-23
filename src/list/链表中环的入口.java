package list;

public class 链表中环的入口 {

    /**
     * 题目：如果一个链表中包含环，那么应该如何找出环的入口节
     * 点？从链表的头节点开始顺着next指针方向进入环的第1个节点为环
     * 的入口节点。例如，在如图4.3所示的链表中，环的入口节点是节点
     * 3。
     * @param args
     */
    public static void main(String[] args) {

    }

    public static ListNode findLoop(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = slow.next;

        while (fast != null && slow != null) {
            if (slow == fast) {
                return slow;
            }

            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }

        return null;
    }
}
