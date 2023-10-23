package dp;

public class 零钱兑换 {

    /**
     * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
     *
     * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
     *
     * 你可以认为每种硬币的数量是无限的。
     */

    public static void main(String[] args) {
        Long l = 12933L;
        Long l2 = 12933L;
        System.out.println(l.equals(l2));
    }

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];

        // 初始化第一行，表示凑成金额0不需要硬币
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        // 用i个硬币，金额为j的时候的最小硬币个数

        // 初始化第一列，表示没有硬币时无法凑成金额
        for (int j = 1; j <= amount; j++) {
            dp[0][j] = amount + 1;
        }

        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j >= coins[i - 1]) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
                }else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[coins.length][amount] > amount ? -1 : dp[coins.length][amount];
    }
}
