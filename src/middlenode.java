import LinkedList.ListNode;

public class middlenode {
    public ListNode middleNode(ListNode head) {
        /**
         * Complexity Analysis
         *
         * Time Complexity: O(N)O(N), where NN is the number of nodes in the given list.
         *
         * Space Complexity: O(N)O(N), the space used by A.
         */
        ListNode[] A = new ListNode[100];
        int t = 0;
        while (head.next != null) {
            A[t++] = head;
            head = head.next;
        }
        return A[t / 2];


        // Approach 2: Fast and Slow Pointer

        /**
         * ListNode slow = head, fast = head;
         *         while (fast != null && fast.next != null) {
         *             slow = slow.next;
         *             fast = fast.next.next;
         *         }
         *         return slow;
         *
         * Complexity Analysis
         *
         * Time Complexity: O(N)O(N), where NN is the number of nodes in the given list.
         *
         * Space Complexity: O(1)O(1), the space used by slow and fast.
         */

    }
}
