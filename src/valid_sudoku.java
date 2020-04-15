/**
Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.

Example 1:

Input:
[
  ["5","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
Output: true

**/

import java.util.Arrays;

public class valid_sudoku {
    public boolean isValidSudoku(char[][] board) {
        int [] vset = new int [9];
        int [] hset = new int [9];
        int [] bckt = new int [9];
        int idx = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    // 5<<2的意思为5的二进制位往左挪两位,等于乘于2的n次方，十进制位是20
                    idx = 1 << (board[i][j] - '0') ;
                    if ((hset[i] & idx) > 0 ||
                            (vset[j] & idx) > 0 ||
                            (bckt[(i / 3) * 3 + j / 3] & idx) > 0) return false;
                    // |= is a bitwise-OR-assignment operator. It takes the current value of the LHS, 
                    // bitwise-ors the RHS, and assigns the value back to the LHS (in a similar fashion to += does with addition)
                    hset[i] |= idx;
                    vset[j] |= idx;
                    // 子九宫格
                    bckt[(i / 3) * 3 + j / 3] |= idx;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
    }
}
