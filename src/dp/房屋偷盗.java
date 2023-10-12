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
     */
    public static int rob(int[] nums) {
        if (nums.length == 0) {return 0;}
        int[] dp = new int[nums.length];

        Arrays.fill(dp, -1);

        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        dp[0] = nums[0];

        if (n > 1) {
            dp[1] = Math.max(dp[0], nums[1]);
        }

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        return Math.max(dp[nums.length - 1], dp[nums.length - 2]);
    }
}
