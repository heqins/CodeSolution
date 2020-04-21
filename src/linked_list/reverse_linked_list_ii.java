/**
Reverse a linked list from position m to n. Do it in one-pass.

Note: 1 ≤ m ≤ n ≤ length of list.

Example:

Input: 1->2->3->4->5->NULL, m = 2, n = 4
Output: 1->4->3->2->5->NULL
**/

/**
很奇怪为何没有倒置链表之一，就来了这个倒置链表之二，不过猜也能猜得到之一就是单纯的倒置整个链表，而这道作为延伸的地方就是倒置其中的某一小段。

对于链表的问题，根据以往的经验一般都是要建一个dummy node，连上原链表的头结点，这样的话就算头结点变动了，

我们还可以通过dummy->next来获得新链表的头结点。这道题的要求是只通过一次遍历完成，就拿题目中的例子来说，变换的是2,3,4这三个点，

我们需要找到第一个开始变换结点的前一个结点，只要让pre向后走m-1步即可，为啥要减1呢，因为题目中是从1开始计数的，这里只走了1步，

就是结点1，用pre指向它。万一是结点1开始变换的怎么办，这就是我们为啥要用dummy结点了，pre也可以指向dummy结点。然后就要开始交换了，

由于一次只能交换两个结点，所以我们按如下的交换顺序：

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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1), pre = dummy;
        dummy.next = head;
        
        for (int i = 0; i < m - 1; i++) pre = pre.next;
        
        ListNode cur = pre.next;
        
        for (int i = m; i < n; i++) {
            ListNode temp = cur.next;
            cur.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
        }
        
        return dummy.next;
    }
}
