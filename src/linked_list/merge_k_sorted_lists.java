import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class merge_k_sorted_lists {
    // O(lg k)
    // Divide and Conquer
    public ListNode mergeKLists2(ListNode[] lists) {
        int k = lists.length;
        if (k == 0)
            return null;
        int interval = 1;
        while (interval < k) {
            for (int i = 0; i < (k - interval); i += interval * 2)
                lists[i] = merge(lists[i], lists[i + interval]);
            interval *= 2;
        }
        return lists[0];
    }

    // Recursive Merge
    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else{
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }

    // Iterative Merge
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode head = (l1.val <= l2.val) ? l1 : l2;
        ListNode last = null;
        while ((l1 != null) && (l2 != null)) {
            while ((l1 != null) && (l1.val <= l2.val)) {
                last = l1;
                l1 = l1.next;
            }
            if (last != null) {
                last.next = l2;
                last = null;
            }
            if (l1 == null)
                break;
            while ((l2 != null) && (l2.val <= l1.val)) {
                last = l2;
                l2 = l2.next;
            }
            if (last != null) {
                last.next = l1;
                last = null;
            }
        }
        return head;
    }

    //PriorityQueue
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(new Comparator<ListNode>(){
            public int compare(ListNode l1, ListNode l2){
                return ((Integer)l1.val).compareTo(l2.val);
            }
        });
        for(int i = 0; i < lists.length; i++)
            if(lists[i] != null)
                q.add(lists[i]);
        ListNode fake = new ListNode(1), lnode = fake;
        while(!q.isEmpty()){
            ListNode node = q.poll();
            lnode.next = node;
            node = node.next;
            if(node != null)    q.add(node);
            lnode = lnode.next;
        }
        return fake.next;
    }

    public static void main(String[] args) {
        ListNode h1 = new ListNode(1);
        ListNode h1_1 = new ListNode(2);
        ListNode h1_2 = new ListNode(3);
        h1.next = h1_1;
        h1_1.next = h1_2;

        ListNode h2 = new ListNode(1);
        ListNode h2_1 = new ListNode(4);
        h2.next = h2_1;

        ListNode h3 = new ListNode(2);

        PriorityQueue q = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode l1, ListNode l2) {
                return ((Integer)l1.val).compareTo((Integer)l2.val);
            }
        });
        ListNode[] lists = new ListNode[]{h1, h2, h3};
        for(int i = 0; i < lists.length; i++) {
            if (lists[i] != null)
                q.add(lists[i]);
        }
    }
}
