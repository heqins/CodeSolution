package dp;

import java.util.Arrays;

public class 房屋偷盗 {

    /**
     * 题目：输入一个数组表示某条街道上的一排房屋内财产的数
     * 量。如果这条街道上相邻的两幢房屋被盗就会自动触发报警系统。
     * 请计算小偷在这条街道上最多能偷取到多少财产。例如，街道上5幢
     * 房屋内的财产用数组[2，3，4，5，3]表示，如果小偷到下标为0、2
     * 和4的房屋内盗窃，那么他能偷取到价值为9的财物，这是他在不触
     * 发报警系统的情况下能偷取到的最多的财物，如图14.3所示。被盗
     * 的房屋上方用特殊符号标出。
     * @param args
     */
    public static void main(String[] args) {

    }

    public static int rob(int[] nums) {
        if (nums.length == 0) {return 0;}
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);

        helper(nums, dp, nums.length - 1);

        return Math.max(dp[nums.length - 1], dp[nums.length - 2]);
    }

    public static void helper(int[] nums, int[] dp, int index) {
        if (index == 0) {
            dp[index] = nums[0];
        }else if (index == 1) {
            dp[index] = Math.max(dp[0], dp[1]);
        }else if (dp[index] < 0) {
            helper(nums, dp, index - 1);
            helper(nums, dp, index - 2);
            dp[index] = Math.max(dp[index - 2] + nums[index], dp[index - 1]);
        }
    }

}
