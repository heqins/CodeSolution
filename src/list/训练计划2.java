package list;

public class 训练计划2 {
    /**
     * 给定一个头节点为 head 的链表用于记录一系列核心肌群训练项目编号，请查找并返回倒数第 cnt 个训练项目编号。
     */
    public ListNode trainingPlan(ListNode head, int cnt) {
        int k = 0;

        ListNode fast = head;
        while (k < cnt && fast != null) {
            fast = fast.next;
            k++;
        }

        ListNode slow = head;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}
