package dp;

import java.util.List;

public class 三角形最小路径和 {

    /**
     * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
     *
     * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
     * 输出：11
     * 解释：如下面简图所示：
     *    2
     *   3 4
     *  6 5 7
     * 4 1 8 3
     * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
     * 示例 2：
     *
     * 输入：triangle = [[-10]]
     * 输出：-10
     *
     */
    private int result = Integer.MAX_VALUE;

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }

        int[][] dp = new int[triangle.size()][triangle.size()];
        dp[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (j == 0) {
                    dp[i][j] = triangle.get(i).get(j) + dp[i - 1][j];
                }else if (j == triangle.get(i).size() - 1) {
                    dp[i][j] = triangle.get(i).get(j) + dp[i - 1][j - 1];
                }else {
                    dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for (int col = 0; col < triangle.get(triangle.size() - 1).size(); col++) {
            result = Math.min(result, dp[triangle.size() - 1][col]);
        }

        return result;
    }

    private int result2 = Integer.MAX_VALUE;

    // 空间复杂度降为O(n)
    public int minimumTotal2(List<List<Integer>> triangle) {
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }

        int[] dp = new int[triangle.size()];
        dp[0] = triangle.get(0).get(0);

        int pre = 0, cur;

        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j <= i; j++) {
                cur = dp[j];
                if (j == 0) {
                    dp[j] = triangle.get(i).get(j) + cur;
                }else if (j == triangle.get(i).size() - 1) {
                    dp[j] = triangle.get(i).get(j) + pre;
                }else {
                    dp[j] = triangle.get(i).get(j) + Math.min(pre, cur);
                }

                pre = cur;
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < dp.length; i++) {
            result = Math.min(result, dp[i]);
        }

        return result;
    }
}
