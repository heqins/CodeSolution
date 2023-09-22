package array;

public class 岛屿数量 {

    /**
     * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
     *
     * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
     *
     * 此外，你可以假设该网格的四条边均被水包围。
     */
    public int numIslands(char[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    // 遍历过程中将岛屿1翻为0
                    helper(grid, i, j);
                    result++;
                }
            }
        }

        return result;
    }

    public void helper(char[][] grid, int i, int j) {
        if (i < 0 || j >= grid[0].length || i >= grid.length || j < 0) {
            return;
        }

        if (grid[i][j] == '0') {
            return;
        }

        if (grid[i][j] == '1') {
            grid[i][j] = '0';

            helper(grid, i, j + 1);
            helper(grid, i, j - 1);
            helper(grid, i + 1, j);
            helper(grid, i - 1, j);
        }
    }
}
