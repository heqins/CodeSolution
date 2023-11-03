package array;

public class 乘积小于k的子数组_2 {

    /**
     * 题目：输入一个由正整数组成的数组和一个正整数k，
     * 请问数组中有多少个数字乘积小于k的连续子数组？例如，输入数组[10，5，2，6]，k的值为100，
     * 有8个子数组的所有数字的乘积小于100，它们分别是[10]、[5]、[2]、[6]、[10，5]、[5，2]、[2，6]和[5，2，6]。
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{10, 5, 2, 6};
        int i = find(nums, 100);
        System.out.println(i);
    }

    /**
     * 时间复杂度：O(n)
     * @param nums
     * @param target
     * @return
     */
    public static int find(int[] nums, int target) {
        int left = 0;
        int prod = 1;
        int count = 0;

        for (int right = 0; right < nums.length; ++right) {
            prod *= nums[right];
            while (left <= right && prod >= target) {
                prod /= nums[left++];
            }

            count += right >= left ? right - left + 1 : 0;
        }

        return count;
    }
}
