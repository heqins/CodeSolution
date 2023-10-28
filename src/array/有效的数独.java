package array;

public class 有效的数独 {

    /**
     * 请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
     *
     * 数字 1-9 在每一行只能出现一次。
     * 数字 1-9 在每一列只能出现一次。
     * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
     *
     *
     * 注意：
     *
     * 一个有效的数独（部分已被填充）不一定是可解的。
     * 只需要根据以上规则，验证已经填入的数字是否有效即可。
     * 空白格用 '.' 表示。
     */
    public static void main(String[] args) {
        char[][] sudoku = {
                {'.', '.', '.', '.', '5', '.', '.', '1', '.'},
                {'.', '4', '.', '3', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '3', '.', '.', '1'},
                {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
                {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
                {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
                {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
                {'.', '.', '4', '.', '.', '.', '.', '.', '.'}
        };

        System.out.println(new 有效的数独().isValidSudoku(sudoku));
    }
    public boolean isValidSudoku(char[][] board) {
        boolean rowFlag = checkRow(board);
        if (!rowFlag) {
            return false;
        }

        boolean colFlag = checkCol(board);
        if (!colFlag) {
            return false;
        }

        boolean matrixFlag = checkMatrix(board);
        if (!matrixFlag) {
            return false;
        }

        return true;
    }

    public boolean checkRow(char[][] board) {
        for (int i = 0; i < board[0].length; i++) {
            int[] num = new int[9];
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] == '.') {
                    continue;
                }

                num[board[j][i] - '1']++;
            }

            for (int x = 0; x < 9; x++) {
                if (num[x] > 1) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean checkCol(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            int[] num = new int[9];
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }

                num[board[i][j] - '1']++;
            }

            for (int x = 0; x < 9; x++) {
                if (num[x] > 1) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean checkMatrix(char[][] board) {
        int i = 0;

        while (i < board.length) {
            for (int j = 0; j < board[0].length; j += 3) {
                int x = i;

                int[] num = new int[9];

                for (int w = 0; w < 3; w++) {
                    int y = j;

                    for (int t = 0; t < 3; t++) {
                        System.out.println("x:" + x + " y:" + y);
                        if (x >= board.length || y >= board[0].length) {
                            y++;
                            continue;
                        }

                        if (board[x][y] == '.') {
                            y++;
                            continue;
                        }

                        num[board[x][y] - '1']++;
                        y++;
                    }

                    x++;
                }

                for (int q = 0; q < 9; q++) {
                    if (num[q] > 1) {
                        return false;
                    }
                }
            }

            i += 3;
        }

        return true;
    }
}
