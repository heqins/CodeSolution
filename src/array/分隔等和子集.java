package array;

import java.util.Arrays;

public class 分隔等和子集 {

    /**
     * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
     */

    public boolean canPartition(int[] nums) {
        int sumAll = Arrays.stream(nums).sum();
        if (sumAll % 2 == 1){
            return false;
        }

        int target = sumAll / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for(int i = 0; i < nums.length; i++){
            for(int j = target; j >= nums[i]; j--){
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[target];
    }
}
