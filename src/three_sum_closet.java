/**
Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. 

Return the sum of the three integers. You may assume that each input would have exactly one solution.

Example:

Given array nums = [-1, 2, 1, -4], and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
**/

import java.util.Arrays;

public class three_sum_closet {
    public int threeSumClosest(int[] nums, int target) {
        // 不要忘了进行排序
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[nums.length-1];
        for (int i = 0; i < nums.length - 2; i++) {
            int mid = i + 1;
            int end = nums.length - 1;
            while (mid < end) {
                int sum = nums[i] + nums[mid] + nums[end];
                if (Math.abs(sum - target) < Math.abs(res - target)) {
                    res = sum;
                }
                if (sum == target) {
                    return target;
                }else if(sum < target) {
                    mid++;
                }else {
                    end--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] test = new int[]{1, 3, 12, 32, 9};
        int target = 6;
        three_sum_closet tsc = new three_sum_closet();
        System.out.println(tsc.threeSumClosest(test, target));
    }
}
