package dp;

public class 环形房屋偷盗 {

    /**
     * 题目：一条环形街道上有若干房屋。输入一个数组表示该条街
     * 道上的房屋内财产的数量。如果这条街道上相邻的两幢房屋被盗就
     * 会自动触发报警系统。请计算小偷在这条街道上最多能偷取的财产
     * 的数量。例如，街道上5家的财产用数组[2，3，4，5，3]表示，如
     * 果小偷到下标为1和3的房屋内盗窃，那么他能偷取到价值为8的财
     * 物，这是他在不触发报警系统的情况下能偷取到的最多的财物，如
     * 图14.4所示。被盗的房屋上方用特殊符号标出。
     * @param args
     */
    public static void main(String[] args) {

    }

    public static int solve(int[] nums) {
        int len = nums.length;
        if (len == 0) {return 0;}

        if (len == 1) {
            return nums[0];
        }

        int result1 = find(nums, 0, len - 2);
        int result2 = find(nums, 1, len - 1);

        return Math.max(result1, result2);
    }

    public static int find(int[] nums, int start, int end) {
        int[] dp = new int[end - start];
        dp[0] = nums[start];
        if (start < end) {
            dp[1] = Math.max(dp[start], dp[start + 1]);
        }

        for (int i = start; i < end; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        return dp[end - 1];
    }
}
