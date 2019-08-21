package LinkedList;

import java.util.HashSet;
import java.util.Set;

public class linked_list_components {
    public int numComponents(ListNode head, int[] G) {
        int count = 0;
        Set<Integer> Gset = new HashSet();
        for (int x: G) Gset.add(x);

        ListNode cur = head;
        while (cur != null) {
            if (Gset.contains(cur.val) && (cur.next == null || !(Gset.contains(cur.next.val)))) {
                count ++;
            }
            cur = cur.next;
        }
        return count;
    }

    public static void main(String[] args) {
        ListNode headA = new ListNode(0);
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        headA.next = a1;
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        int[] G = new int[]{0, 3, 1, 4};
        linked_list_components llc = new linked_list_components();
        System.out.println(llc.numComponents(headA, G));
    }
}
