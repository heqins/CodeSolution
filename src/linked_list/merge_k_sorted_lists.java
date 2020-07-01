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

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class merge_k_sorted_lists {
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


// 分治法
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        n = len(lists)
        
        # basic cases
        if lenth == 0: return None
        if lenth == 1: return lists[0]
        if lenth == 2: return self.mergeTwoLists(lists[0], lists[1])
        
        # divide and conqure if not basic cases
        mid = n // 2
        return self.mergeTwoLists(self.mergeKLists(lists[:mid]), self.mergeKLists(lists[mid:n]))
    
    
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        res = ListNode(0)
        c1, c2, c3 = l1, l2, res
        while c1 or c2:
            if c1 and c2:
                if c1.val < c2.val:
                    c3.next = ListNode(c1.val)
                    c1 = c1.next
                else:
                    c3.next = ListNode(c2.val)
                    c2 = c2.next
                c3 = c3.next
            elif c1:
                c3.next = c1
                break
            else:
                c3.next = c2
                break
            
        return res.next
