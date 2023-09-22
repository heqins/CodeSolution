package matrix;

public class 最小路径和 {
    /**
     * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
     *
     * 说明：每次只能向下或者向右移动一步。
     */

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 2, 3}, {4, 5, 6}};
        minPathSum(grid);

    }

    public static int minPathSum(int[][] grid) {
        if (grid.length == 0) {
            return -1;
        }
        // 可以原地修改数组，每个位置由上面或左边的最小值+当前值来更新
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (j == 0 && i == 0) {
                    continue;
                }

                if (j == 0) {
                    grid[i][j] = grid[i - 1][j] + grid[i][j];
                    continue;
                }

                if (i == 0) {
                    grid[i][j] = grid[i][j - 1] + grid[i][j];
                    continue;
                }

                grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
            }
        }

        return grid[grid.length - 1][grid[0].length - 1];
    }
}
