package matrix;

public class 最大正方形_1 {

    /**
     * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
     */
    public int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];

        int slide = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == '1') {
                dp[i][0] = 1;
                // 边上也要更新正方形边长
                slide = 1;
            }
        }

        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == '1') {
                dp[0][j] = 1;
                // 边上也要更新正方形边长
                slide = 1;
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    // 考虑当前是正方形的右下角，取决于左边，上面，左上的最小边长
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                    // 用于记录见过的最大边长
                    slide = Math.max(slide, dp[i][j]);
                }
            }
        }

        return slide * slide;
    }
}
