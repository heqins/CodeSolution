package stack;

import java.util.Arrays;
import java.util.Stack;

public class 小行星碰撞 {

    /**
     * 题目：输入一个表示小行星的数组，数组中每个数字的绝对值
     * 表示小行星的大小，数字的正负号表示小行星运动的方向，正号表
     * 示向右飞行，负号表示向左飞行。如果两颗小行星相撞，那么体积
     * 较小的小行星将会爆炸最终消失，体积较大的小行星不受影响。如
     * 果相撞的两颗小行星大小相同，那么它们都会爆炸消失。飞行方向
     * 相同的小行星永远不会相撞。求最终剩下的小行星。例如，有6颗小
     * 行星[4，5，-6，4，8，-5]，如图6.2所示（箭头表示飞行的方
     * 向），它们相撞之后最终剩下3颗小行星[-6，4，8]。
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, -6, 4, 8, -5};
        int[] ints = find(nums);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] find(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        for (int num: nums) {
            while (!stack.isEmpty() && stack.peek() > 0  && num < 0 && Math.abs(stack.peek()) < Math.abs(num)) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                stack.push(num);
            }else {
                int top = stack.peek();
                if (top > 0 && num < 0) {
                    if (Math.abs(top) > Math.abs(num)) {
                        continue;
                    }else {
                        stack.pop();
                    }
                }else {
                    stack.push(num);
                }
            }
        }

        return stack.stream().mapToInt(i->i).toArray();
    }
}
