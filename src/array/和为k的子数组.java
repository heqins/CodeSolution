package array;

import java.util.HashMap;
import java.util.Map;

public class 和为k的子数组 {

    /**
     * 题目：输入一个整数数组和一个整数k，请问数组中有多少个数字之和等于k的连续子数组？
     * 例如，输入数组[1，1，1]，k的值为2，有2个连续子数组之和等于2。
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1};
        int i = find(nums, 2);
        System.out.println(i);
    }

    public static int find(int[] nums, int k) {
        int sum = 0;
        int count = 0;

        Map<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0, 1);

        for (int num: nums) {
            sum += num;
            count += sumMap.getOrDefault(sum - k, 0);
            sumMap.put(sum, sumMap.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static int find2(int[] nums, int k) {
        int sum = 0;
        int count = 0;
        int[] sumArray = new int[nums.length + 1];

        sumArray[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            sum += nums[i - 1];
            count += sumArray[sum - k];
        }

        return count;
    }
}
