package dp;

public class 跳跃训练 {
    /**
     * 今天的有氧运动训练内容是在一个长条形的平台上跳跃。平台有 num 个小格子，每次可以选择跳 一个格子 或者 两个格子。请返回在训练过程中，学员们共有多少种不同的跳跃方式。
     *
     * 结果可能过大，因此结果需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     */
    private final int max = 1000000007;
    public int trainWays(int num) {
        if (num == 0) {
            return 1;
        }

        if (num <= 2) {
            return num;
        }

        int[] dp = new int[num + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= num; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % max;
        }

        return dp[num];
    }
}
