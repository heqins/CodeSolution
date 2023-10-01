package array;

public class 乘积最大数组 {

    /**
     * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
     *
     * 测试用例的答案是一个 32-位 整数。
     *
     * 子数组 是数组的连续子序列。
     */
    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int[] dp = new int[nums.length];
        int[] dpMin = new int[nums.length];

        dp[0] = nums[0];
        dpMin[0] = nums[0];

        int result = 0;
        // 当前乘积最大的 = 1、当前负数，前一个位置的最大负数 * 当前数 2、当前正数，前一个位置的最大正数 * 当前数
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                dp[i] = Math.max(nums[i], dpMin[i - 1] * nums[i]);
                dpMin[i] = Math.min(nums[i], dp[i - 1] * nums[i]);
            }else {
                dp[i] = Math.max(nums[i], dp[i - 1] * nums[i]);
                dpMin[i] = Math.min(nums[i], dpMin[i - 1] * nums[i]);
            }

        }

        for (int i = 0; i < nums.length; i++) {
            result = Math.max(result, dp[i]);
        }

        return result;
    }
}
