package matrix;

public class 翻转矩阵后的最大的分 {

    /**
     * 给你一个大小为 m x n 的二元矩阵 grid ，矩阵中每个元素的值为 0 或 1 。
     *
     * 一次 移动 是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
     *
     * 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的 得分 就是这些数字的总和。
     *
     * 在执行任意次 移动 后（含 0 次），返回可能的最高分数。
     */
    public int matrixScore(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Step 1: 确保第一列都为1
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 0) {
                // 每次要变同一行或同一列
                for (int j = 0; j < n; j++) {
                    grid[i][j] = 1 - grid[i][j];
                }
            }
        }

        // Step 2: 最大化每一列的1的数量
        for (int j = 1; j < n; j++) {
            int countOnes = 0;
            for (int i = 0; i < m; i++) {
                countOnes += grid[i][j];
            }
            if (countOnes < m - countOnes) {
                for (int i = 0; i < m; i++) {
                    grid[i][j] = 1 - grid[i][j];
                }
            }
        }

        // Step 3: 计算得分
        int score = 0;
        for (int j = 0; j < n; j++) {
            int columnSum = 0;
            for (int i = 0; i < m; i++) {
                columnSum += grid[i][j];
            }
            int columnScore = Math.max(columnSum, m - columnSum);
            score += columnScore * (1 << (n - 1 - j));
        }

        return score;
    }

    public static void main(String[] args) {
        matrixScore2(new int[][]{{0, 0, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 0}});
    }
    public static int matrixScore2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 0) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = 1 - grid[i][j];
                }
            }
        }

        for (int j = 1; j < n; j++) {
            int countOnes = 1;
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 1) {
                    countOnes++;
                }
            }

            if (countOnes < m - countOnes) {
                for (int i = 0; i < m; i++) {
                    grid[i][j] = 1 - grid[i][j];
                }
            }
        }

        int result = 0;
        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int exp = n - j - 1;
                    sum += Math.pow(2, exp);
                }

            }

            result += sum;
        }

        return result;
    }
}
