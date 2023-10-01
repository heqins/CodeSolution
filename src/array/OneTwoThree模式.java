package array;

import java.util.Stack;

public class OneTwoThree模式 {

    /**
     * 给你一个整数数组 nums ，数组中共有 n 个整数。132 模式的子序列 由三个整数 nums[i]、nums[j] 和 nums[k] 组成，并同时满足：i < j < k 和 nums[i] < nums[k] < nums[j] 。
     *
     * 如果 nums 中存在 132 模式的子序列 ，返回 true ；否则，返回 false 。
     */
    public boolean find132pattern(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int thrid = Integer.MIN_VALUE;

        // 因为是单调递减栈，所以需要从后往前遍历
        // 对于单调递减栈，当出现大于栈顶元素的时候，需要出栈，此时当前元素就相当于中间元素j，其值是最大的，
        // 用第三个指针记录元素k，其值是中间的，每次遍历的指针是i，其值应当是最小的，用i的值和third比较
        for (int i = nums.length - 1; i >= 0; i--) {
            if (thrid > nums[i]) {
                return true;
            }

            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                thrid = stack.pop();
            }

            if (stack.isEmpty() || nums[i] <= stack.peek()) {
                stack.push(nums[i]);
            }
        }

        return false;
    }
}
