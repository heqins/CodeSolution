package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N皇后 {

    /**
     * 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
     * n皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
     * 给你一个整数n，返回所有不同的 n皇后问题 的解决方案。
     * 每一种解法包含一个不同的n皇后问题的棋子放置方案，该方案中'Q'和'.'分别代表了皇后和空位。
     */

    // n皇后，二维矩阵问题
    public List<List<String>> solveNQueens(int n) {
        char[][] checkBoard = new char[n][n];
        for (char[] temp: checkBoard) {
            Arrays.fill(temp, '.');
        }

        List<List<String>> res = new ArrayList();

        helper(checkBoard, res, n, 0);

        return res;
    }

    public void helper(char[][] checkBoard, List<List<String>> res,
                       int n, int row) {
        if (row == n) {
            // checkBoard -> res
            List<String> result = Array2List(checkBoard);
            res.add(result);

            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValid(checkBoard, row, col, n)) {
                checkBoard[row][col] = 'Q';

                helper(checkBoard, res, n, row + 1);

                checkBoard[row][col] = '.';
            }
        }
    }

    public List<String> Array2List(char[][] checkBoard) {
        List<String> list = new ArrayList();
        for (char[] temp: checkBoard) {
            String str = new String(temp);
            list.add(str);
        }

        return list;
    }

    public boolean isValid(char[][] checkBoard, int row, int col, int n) {
        for (int i = 0; i < n; i++) {
            if (checkBoard[i][col] == 'Q') {
                return false;
            }
        }

        // 检查两个斜线
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--,j--) {
            if (checkBoard[i][j] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i --, j++) {
            if (checkBoard[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }
}
