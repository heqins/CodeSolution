/**
测试用例

    功能测试（输入的链表含有多个节点；链表中只有一个节点）
    特殊功能测试（链表头节点为空指针）

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
