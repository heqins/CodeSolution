package stack;

import java.util.Arrays;
import java.util.Stack;

public class 每日温度 {

    /**
     * 题目：输入一个数组，它的每个数字是某天的温度。请计算每
     * 天需要等几天才会出现更高的温度。例如，如果输入数组[35，31，
     * 33，36，34]，那么输出为[3，1，1，0，0]。由于第1天的温度是
     * 35°C，要等3天才会出现更高的温度36°C，因此对应的输出为3。第4
     * 天的温度是36°C，后面没有更高的温度，它对应的输出是0。其他的
     * 以此类推。
     * @param args
     */
    public static void main(String[] args) {
        int[] ints = find(new int[]{35, 31, 33, 36, 34});
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 栈里保存的是元素的下标，是一个单调递减的栈（栈里元素对应下标的值是单调递减的），如果当前温度比栈顶的高，那么出栈
     * @param nums
     * @return
     */
    public static int[] find(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums.length];

        stack.push(0);

        for (int i = 1; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                int prev = stack.pop();
                result[prev] = i - prev;
            }

            stack.push(i);
        }

        return result;
    }
}
