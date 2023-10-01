package matrix;

public class 统计封闭岛屿的数目 {

    /**
     * 二维矩阵 grid 由 0 （土地）和 1 （水）组成。岛是由最大的4个方向连通的 0 组成的群，
     * 封闭岛是一个 完全 由1包围（左、上、右、下）的岛。
     *
     * 请返回 封闭岛屿 的数目。
     */
    public int closedIsland(int[][] grid) {
        int result = 0;
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && helper(grid, i, j, m, n)) {
                    result++;
                }
            }
        }

        return result;
    }

    // https://leetcode.cn/problems/number-of-closed-islands/description/
    public boolean helper(int[][] grid, int i, int j, int m, int n) {
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return false;
        }

        if (grid[i][j] != 0) {
            return true;
        }

        grid[i][j] = -1;

        boolean ret1 = helper(grid, i - 1, j, m, n);
        boolean ret2 = helper(grid, i + 1, j, m, n);
        boolean ret3 = helper(grid, i, j + 1, m, n);
        boolean ret4 = helper(grid, i, j - 1, m, n);

        return ret1 && ret2 && ret3 && ret4;
    }
}
