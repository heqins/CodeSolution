package matrix;

public class 单词搜索 {

    /**
     * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
     *
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
     */
    private int[][] direction = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;

        if (board.length == 0) {
            return false;
        }

        int[][] used = new int[row][col];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean result = helper(board, i, j, used, word, 1);
                if (result) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean helper(char[][] board, int i, int j, int[][] used, String word, int len) {
        if (i >= board.length || j >= board[0].length || i < 0 || j < 0) {
            return false;
        }

        if (len > word.length()) {
            return false;
        }

        if (used[i][j] == 1) {
            return false;
        }

        // 只有当前字符匹配了才往下走
        if (board[i][j] == word.charAt(len - 1)) {
            if (len == word.length()) {
                return true;
            }

            // 回溯，记忆
            used[i][j] = 1;

            for (int w = 0; w < 4; w++) {
                int newX = direction[w][0] + i;
                int newY = direction[w][1] + j;

                if (helper(board, newX, newY, used, word, len + 1)) {
                    return true;
                }
            }

            used[i][j] = 0;
        }

        return false;
    }
}
