package matrix;

public class 岛屿的最大面积_1 {

    /**
     * 给你一个大小为 m x n 的二进制矩阵 grid 。
     *
     * 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
     *
     * 岛屿的面积是岛上值为 1 的单元格的数目。
     *
     * 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
     */
    private int result = 0;
    int[][] direction = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int maxAreaOfIsland(int[][] grid) {
        int result = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int length = helper(grid, i, j);

                    result = Math.max(result, length);
                }
            }
        }

        return result;
    }

    public int helper(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1) {
            return 0;
        }

        // 需要采用沉岛的思想，不能用回溯，因为回溯的时候一个点两边的岛如果没有通路，那么回溯岛上一层后数量就少了1个
        // 数量直接相加

        grid[i][j] = 0;

        int sum = 1;

        sum += helper(grid, i - 1, j);
        sum += helper(grid, i, j - 1);
        sum += helper(grid, i + 1, j);
        sum += helper(grid, i, j + 1);

        return sum;
    }
}
