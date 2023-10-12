package dp;

public class 爬楼梯的最少成本 {


    /**
     * 题目：一个数组cost的所有数字都是正数，它的第i个数字表示
     * 在一个楼梯的第i级台阶往上爬的成本，在支付了成本cost[i]之后
     * 可以从第i级台阶往上爬1级或2级。假设台阶至少有2级，既可以从
     * 第0级台阶出发，也可以从第1级台阶出发，请计算爬上该楼梯的最
     * 少成本。例如，输入数组[1，100，1，1，100，1]，则爬上该楼梯
     * 的最少成本是4，分别经过下标为0、2、3、5的这4级台阶，如图
     * 14.1所示。
     * @param args
     */
    public static void main(String[] args) {
        // 自下而上解决问题
        System.out.println(minCostClimbingStairs(new int[]{1, 100, 1, 1, 100, 1}));
    }

    public static int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len];

        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < len; i++) {
            dp[i] = Math.min(dp[i - 2], dp[i - 1]) + cost[i];
        }

        // 可以从倒数第二或倒数第一来跳跃
        return Math.min(dp[len - 2], dp[len - 1]);
    }

    // 空间复杂度:O(1)
    public static int solve(int[] cost) {
        int len = cost.length;
        int[] dp = new int[]{cost[0], cost[1]};
        for (int i = 2; i < len; i++) {
            dp[i % 2] = Math.min(dp[0], dp[1]) + cost[i];
        }

        return Math.min(dp[0], dp[1]);
    }
}
