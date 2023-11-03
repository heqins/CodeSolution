package list;

public class 合并k个升序链表 {
    /**
     * 给你一个链表数组，每个链表都已经按升序排列。
     *
     * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
     *
     *
     *
     * 示例 1：
     *
     * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
     * 输出：[1,1,2,3,4,4,5,6]
     * 解释：链表数组如下：
     * [
     *   1->4->5,
     *   1->3->4,
     *   2->6
     * ]
     * 将它们合并到一个有序链表中得到。
     * 1->1->2->3->4->4->5->6
     * 示例 2：
     *
     * 输入：lists = []
     * 输出：[]
     * 示例 3：
     *
     * 输入：lists = [[]]
     * 输出：[]
     */
    public ListNode mergeKLists(ListNode[] lists) {
        int[] nums = new int[20001];

        for (int i = 0; i < lists.length; i++) {
            ListNode cur = lists[i];
            while (cur != null) {
                nums[cur.val + 10000]++;
                cur = cur.next;
            }
        }

        ListNode dummy =new ListNode(-1);
        ListNode head = dummy;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                int times = nums[i];
                for (int j = 0; j < times; j++) {
                    ListNode temp = new ListNode(i - 10000);
                    head.next = temp;
                    head = temp;
                }
            }
        }

        return dummy.next;
    }
}
