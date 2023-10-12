package list;

public class 两个链表的第1个重合节点 {

    /**
     * 题目：输入两个单向链表，请问如何找出它们的第1个重合节
     * 点。例如，图4.5中的两个链表的第1个重合节点的值是4。
     * @param args
     */
    public static ListNode findIntersectionNode(ListNode l1, ListNode l2) {
        int length1 = countListNode(l1);
        int length2 = countListNode(l2);

        int diff = Math.abs(length1 - length2);
        ListNode shorter = length1 < length2 ? l1 : l2;
        ListNode longer = length1 > length2 ? l2 : l1;
        ListNode start = longer;
        for (int i = 0; i < diff; i++) {
            start = start.next;
        }

        ListNode node1 = shorter;
        while (node1 != null && start != null) {
            if (node1 == start) {
                return start;
            }

            node1 = node1.next;
            start = start.next;
        }

        return null;
    }

    public static int countListNode(ListNode head) {
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        return count;
    }
}
