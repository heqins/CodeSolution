/**
Write a program to find the node at which the intersection of two singly linked lists begins.

For example, the following two linked lists:
**/


/**
 * 方法2：判断两个链表相交的第一个结点：用到快慢指针，推荐（更优解）
 *
 * 我们在上面的方法2中，之所以用到栈，是因为我们想同时遍历到达两个链表的尾结点。
 * 其实为解决这个问题我们还有一个更简单的办法：首先遍历两个链表得到它们的长度。
 * 在第二次遍历的时候，在较长的链表上走 |len1-len2| 步，接着再同时在两个链表上遍历，找到的第一个相同的结点就是它们的第一个交点。
 *
 * 这种思路的时间复杂度也是O(len1+len2)，但是我们不再需要辅助栈，因此提高了空间效率。当面试官肯定了我们的最后一种思路的时候，就可以动手写代码了。
 */

public class intersection_of_two_linkedlist {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;
        ListNode tempA = headA,tempB = headB;

        while(tempA != null){
            lenA++;
            tempA = tempA.next;
        }
        while(tempB != null){
            lenB++;
            tempB = tempB.next;
        }

        if(lenA >= lenB){
            while(lenA != lenB){
                headA = headA.next;
                lenA --;
            }
        }
        else {
            while(lenA != lenB){
                headB = headB.next;
                lenB --;
            }
        }

        while((headA != headB) && (headA != null) && (headB != null)){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    public static void main(String[] args) {
        ListNode headA = new ListNode(4);
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(8);
        ListNode a3 = new ListNode(5);
        ListNode a4 = new ListNode(4);

        ListNode headB = new ListNode(5);
        ListNode b1 = new ListNode(0);
        ListNode b2 = new ListNode(1);
        ListNode b3 = new ListNode(8);
        ListNode b4 = new ListNode(4);
        ListNode b5 = new ListNode(5);

        headA.next = a1;
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        headB.next = b1;
        b1.next = b2;
        b2.next = b3;
        b3.next = b4;
        b4.next = b5;

        intersection_of_two_linkedlist iotl = new intersection_of_two_linkedlist();
        System.out.println(iotl.getIntersectionNode(headA, headB).val);
    }
}
