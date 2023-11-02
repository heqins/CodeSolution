package list;

public class 相交链表_1 {

    /**
     * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null) {
            return headB;
        }

        if (headB == null) {
            return headA;
        }

        int lenA = getLength(headA);
        int lenB = getLength(headB);

        if (lenA > lenB) {
            int range = lenA - lenB;
            while (range != 0) {
                headA = headA.next;
                range--;
            }
        }else if (lenA < lenB) {
            int range = lenB - lenA;
            while (range != 0) {
                headB = headB.next;
                range--;
            }
        }

        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }

            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }

    public int getLength(ListNode head) {
        int length = 0;
        ListNode dummy = head;
        while (dummy != null) {
            dummy = dummy.next;
            length++;
        }

        return length;
    }
}
