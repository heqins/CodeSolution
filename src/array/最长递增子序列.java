package array;

import java.util.Arrays;

public class 最长递增子序列 {

    /**
     * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
     * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
     */
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }

        if (len == 1) {
            return 1;
        }

        int[] dp = new int[len];

        // 初始化最长序列长度为1
        Arrays.fill(dp, 1);

        int result = Integer.MIN_VALUE;

        for (int i = 1; i < len; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }

                result = Math.max(dp[i], result);
            }
        }

        return result;
    }
}
