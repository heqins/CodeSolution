package stack;

import java.util.Arrays;
import java.util.Stack;

public class 下一个更大元素2 {
    /**
     * 给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的 下一个更大元素 。
     *
     * 数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1 。
     */

    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];

        Arrays.fill(result, -1);

        Stack<Integer> stack = new Stack<>();

        int length = nums.length;
        // 使用length * 2是为了方便循环遍历一遍
        // 如果当前元素的值大于栈顶的值则出栈，更新栈顶元素对应的答案位置
        for (int i = 0; i < length * 2 ; i++) {
            while (!stack.isEmpty() && nums[i % length] > nums[stack.peek()]) {
                int u = stack.pop();

                result[u] = nums[i % length];
            }

            stack.push(i % length);
        }

        return result;
    }
}
