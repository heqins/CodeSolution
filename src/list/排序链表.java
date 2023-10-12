package list;

public class 排序链表 {

    /**
     * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
     */
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // 归并排序
        ListNode rightNewHead = sortList(slow.next);

        // 切分后，需要断链避免后序遍历一直在跑
        slow.next = null;

        ListNode leftNewHead = sortList(head);

        ListNode newHead = merge(leftNewHead, rightNewHead);

        return newHead;
    }

    public ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;

        while (left != null && right != null) {
            ListNode temp;
            if (left.val <= right.val) {
                temp = new ListNode(left.val);
                left = left.next;
            }else {
                temp = new ListNode(right.val);
                right = right.next;
            }

            head.next = temp;
            head = temp;
        }

        while (left != null) {
            head.next = left;
            head = left;

            left = left.next;
        }

        while (right != null) {
            head.next = right;
            head = right;

            right = right.next;
        }

        return dummy.next;
    }

    public ListNode sortList2(ListNode head) {
        if (head == null) {
            return head;
        }

        if (head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode rightHead = sortList2(slow.next);
        slow.next = null;

        ListNode leftHead = sortList2(head);

        ListNode newHead = merge2(leftHead, rightHead);

        return newHead;
    }

    public ListNode merge2(ListNode left, ListNode right) {
        ListNode l = left;
        ListNode r = right;

        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;

        while (l != null && r != null) {
            if (l.val >= r.val) {
                head.next = r;
                r = r.next;
            }else {
                head.next = l;
                l = l.next;
            }

            head = head.next;
        }

        while (l != null) {
            head.next = l;
            head = head.next;
            l = l.next;
        }

        while (r != null) {
            head.next = r;
            head = head.next;
            r = r.next;
        }

        return dummy.next;
    }
}
