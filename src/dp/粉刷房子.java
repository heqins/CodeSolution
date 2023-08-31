package dp;

public class 粉刷房子 {

    /**
     * 题目：一排n幢房子要粉刷成红色、绿色和蓝色，不同房子被粉
     * 刷成不同颜色的成本不同。用一个n×3的数组表示n幢房子分别用3
     * 种颜色粉刷的成本。要求任意相邻的两幢房子的颜色都不一样，请
     * 计算粉刷这n幢房子的最少成本。例如，粉刷3幢房子的成本分别为
     * [[17，2，16]，[15，14，5]，[13，3，1]]，如果分别将这3幢房子
     * 粉刷成绿色、蓝色和绿色，那么粉刷的成本是10，是最少的成本。
     * @param args
     */
    public static void main(String[] args) {

    }

    public static int solve(int[][] costs) {
        if (costs.length == 0) {
            return 0;
        }

        int[][] dp = new int[2][3];
        for (int i = 0; i < 3; i++) {
            dp[i][0] = costs[0][i];
        }

        for (int i = 1; i < costs.length; i++) {
            for (int j = 0; j < 3; j++) {
                int prev1 = dp[(i - 1) % 2][(j + 1) % 3];
                int prev2 = dp[(i - 1) % 2][(j + 2) % 3];

                dp[i % 2][j] = Math.min(prev1, prev2) + costs[i][j];
            }
        }

        int last = (costs.length - 1) % 2;

        return Math.min(dp[last][0], Math.min(dp[last][1], dp[last][2]));
    }
}
