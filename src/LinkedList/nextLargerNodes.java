package LinkedList;

import java.util.ArrayList;
import java.util.Stack;

public class nextLargerNodes {
    public int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer> nums = new ArrayList<>();
        while (head != null) {
            nums.add(head.val);
            head = head.next;
        }
        Stack<Integer> s = new Stack<>();
        int[] ans = new int[nums.size()];
        for (int i = nums.size() - 1; i >= 0; i--) {
            while (!s.empty() && s.peek() <= nums.get(i)) s.pop();
            ans[i] = s.empty() ? 0 : s.peek();
            s.push(nums.get(i));
        }
        return ans;
    }
}
