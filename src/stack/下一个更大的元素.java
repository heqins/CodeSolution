package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class 下一个更大的元素 {

    /**
     * nums1 中数字 x 的 下一个更大元素 是指 x 在 nums2 中对应位置 右侧 的 第一个 比 x 大的元素。
     *
     * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，下标从 0 开始计数，其中nums1 是 nums2 的子集。
     *
     * 对于每个 0 <= i < nums1.length ，找出满足 nums1[i] == nums2[j] 的下标 j ，并且在 nums2 确定 nums2[j] 的 下一个更大元素 。如果不存在下一个更大元素，那么本次查询的答案是 -1 。
     *
     * 返回一个长度为 nums1.length 的数组 ans 作为答案，满足 ans[i] 是如上所述的 下一个更大元素 。
     */

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int length1 = nums1.length, length2 = nums2.length;
        Map<Integer, Integer> map = new HashMap();
        Stack<Integer> stack = new Stack();

        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                int greaterNum = stack.pop();
                map.put(greaterNum, nums2[i]);
            }

            stack.push(nums2[i]);
        }

        int[] res = new int[length1];
        for (int i = 0; i < nums1.length; i++) {
            int index = map.getOrDefault(nums1[i], -1);
            res[i] = index;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println('x' - 'a');
    }
}
