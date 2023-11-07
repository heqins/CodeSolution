package graph;

public class 最长递增路径_3 {

    /**
     * 题目：输入一个整数矩阵，请求最长递增路径的长度。矩阵中
     * 的路径沿着上、下、左、右4个方向前行。例如，图15.14中矩阵的
     * 最长递增路径的长度为4，其中一条最长的递增路径为3→4→5→8，
     * 如阴影部分所示。
     * @param args
     */
    public static int solve(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int[][] lengths = new int[row][col];

        int result = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int length = dfs(matrix, lengths, i, j);
                result = Math.max(result, length);
            }
        }

        return result;
    }

    public static int dfs(int[][] matrix, int[][] lengths, int i, int j) {
        if (lengths[i][j] != 0) {
            return lengths[i][j];
        }

        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        int length = 1;

        for (int[] dir: dirs) {
            int x = i + dir[0];
            int y = j + dir[1];

            if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length
                    && matrix[x][y] > matrix[i][j]) {
                int path = dfs(matrix, lengths, x, y);
                length = Math.max(path + 1, length);
            }
        }

        lengths[i][j] = length;
        return length;
    }
}
