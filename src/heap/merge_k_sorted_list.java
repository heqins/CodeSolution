/**
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6
**/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            public int compare(ListNode l1, ListNode l2) {
                return ((Integer)l1.val).compareTo(l2.val);
            }
        });
        
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                queue.add(lists[i]);
            }
        }
        
        ListNode dummy = new ListNode(1);
        ListNode lnode = dummy;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            lnode.next = node;
            node = node.next;
            if (node != null) queue.add(node);
            lnode = lnode.next;
        }
        
        return dummy.next;
    }
}
