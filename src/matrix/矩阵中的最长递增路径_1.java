package matrix;

public class 矩阵中的最长递增路径_1 {

    /**
     * 给定一个 m x n 整数矩阵 matrix ，找出其中 最长递增路径 的长度。
     *
     * 对于每个单元格，你可以往上，下，左，右四个方向移动。 你 不能 在 对角线 方向上移动或移动到 边界外（即不允许环绕）。
     */
    private int result = 0;

    private int[][] direction = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;

        int n = matrix[0].length;

        int[][] used = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (used[i][j] != 0) {
                    continue;
                }

                // 记忆化搜索，已经搜索过的地方可以跳过
                result = Math.max(result, helper(matrix, i, j, used));
            }
        }

        return result;
    }

    // 记忆化搜索和回溯还不太一样。记忆化搜索不会回退状态，而是在递归调用中使用已经计算的结果，以避免重复计算。
    public int helper(int[][] matrix, int i, int j, int[][] used) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) {
            return 0;
        }

        if (used[i][j] != 0) {
            return used[i][j];
        }

        int length = 1;

        for (int x = 0; x < 4; x++) {
            int newX = i + direction[x][0];
            int newY = j + direction[x][1];

            if (newX >= matrix.length || newY >= matrix[0].length || newX < 0 || newY < 0) {
                continue;
            }

            if (matrix[newX][newY] > matrix[i][j]) {
                length = Math.max(length, helper(matrix, newX, newY, used) + 1);
            }
        }

        used[i][j] = length;

        return length;
    }
}
