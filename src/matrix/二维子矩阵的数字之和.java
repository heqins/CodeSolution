package matrix;

public class 二维子矩阵的数字之和 {

    /**
     * 题目：输入一个二维矩阵，如何计算给定左上角坐标和右下角坐标的子矩阵的数字之和？对于同一个二维矩阵，
     * 计算子矩阵的数字之和的函数可能由于输入不同的坐标而被反复调用多次。
     * 例如，输入图2.1中的二维矩阵，以及左上角坐标为（2，1）和右下角坐标为（4，3）的子矩阵，该函数输出8。
     * @param args
     */

    // 思路是利用前缀和矩阵来得到子矩阵的和
    private int[][] prefixSum;

    public void solve(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        prefixSum = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                prefixSum[i][j] = matrix[i - 1][j - 1] + prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return prefixSum[row2 + 1][col2 + 1] - prefixSum[row1][col2 + 1] - prefixSum[row2 + 1][col1] + prefixSum[row1][col1];
    }
}
