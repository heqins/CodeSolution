/**
测试用例

    功能测试（输入的链表含有多个节点；链表中只有一个节点）
    特殊功能测试（链表头节点为空指针）

主要的过程有以下三步：

    定义一个将指向反转链表的头指针和一个保存临时节点的指针
    循环头节点的下一个节点，如果不为空，则将它的下一个节点作为新的头结点，并用临时节点保存之前头节点
    然后就是链表的重排问题了，首先原链表的头结点，将指向的新的头节点的下一个节点，新的头节点将指向原来的头结点

**/

/**
 * 反转链表
 *
 * @Author rex
 * 2018/7/28
 */
public class Solution {
    /**
     * 自己解法
     * @param head
     * @return
     */
    public ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode currHead = head;
        ListNode temp = null;
        while (head.next != null) {
            temp = currHead;
            currHead = head.next;
            head.next = head.next.next;
            currHead.next = temp;
        }
        return currHead;
    }
}
