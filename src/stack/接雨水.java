package stack;

import java.util.Stack;

public class 接雨水 {

    public static void main(String[] args) {
        int[] heights = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(heights));
    }

    /**
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     */
    public static int trap(int[] height) {
        int sum = 0;

        if (height.length <= 2) {
            return 0;
        }

        Stack<Integer> stack = new Stack();

        // 栈里存的是下标

        stack.push(0);

        for (int i = 1; i < height.length; i++) {
            // 分为三种情况，当前柱子高度比栈顶大，小，相等的情况

            if (height[i] == height[stack.peek()]) {
                stack.pop();
                stack.push(i);
            }else if (height[i] < height[stack.peek()]) {
                stack.push(i);
            }else {
                // 雨水面积 = (左边柱子高度和右边柱子高度中最小的那个 - 中间柱子的高度 ) * 宽度
                // 宽度 = （右边柱子索引 - 左边柱子索引 - 1）
                while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                    int mid = stack.pop();

                    if (!stack.isEmpty()) {
                        int minHeight = Math.min(height[stack.peek()], height[i]) - height[mid];
                        sum += (i - stack.peek() - 1) * minHeight;
                    }
                }

                stack.push(i);
            }
        }

        return sum;
    }
}
