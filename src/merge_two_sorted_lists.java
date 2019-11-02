public class merge_two_sorted_lists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null) {
            return l2;
        } else if (l2 == null){
            return l1;
        }
        ListNode l3 = new ListNode(0);
        ListNode cur = l3;
        while (l1 != null && l2 != null) {
            if (l1.val >= l2.val) {
                cur.next = l2;
                l2 = l2.next;
            }else {
                cur.next = l1;
                l1 = l1.next;
            }
            cur = cur.next;
        }
        if (l1 != null) {
            cur.next = l1;
        }
        if (l2 != null) {
            cur.next = l2;
        }
        return l3.next;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(3);
        ListNode a2 = new ListNode(6);
        ListNode a3 = new ListNode(9);
        ListNode head2 = new ListNode(1);
        ListNode b2 = new ListNode(2);
        head1.next = a2;
        a2.next = a3;
        head2.next = b2;
        merge_two_sorted_lists mt = new merge_two_sorted_lists();
        System.out.println(mt.mergeTwoLists(head1, head2).next.next.val);
    }
}
