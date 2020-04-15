/**
Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

Example:

Input: 3
Output:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
**/

class Solution {
    public int[][] generateMatrix(int n) {
       int[][] matrix = new int[n][n];
        int num = 1;
        for (int offset = 0; offset < (n + 1) / 2; offset++) {
            for (int col = offset; col < n - offset; col++) {
                matrix[offset][col] = num++;
            }
            for (int row = offset + 1; row < n - offset - 1; row++) {
                matrix[row][n - offset - 1] = num++;
            }
            if (offset != n - offset - 1) {
                for (int col = n - offset - 1; col >= offset; col--) {
                    matrix[n - offset - 1][col] = num++;
                }
            }
            if (offset != n - offset - 1) {
                for (int row = n - offset - 2; row > offset; row--) {
                    matrix[row][offset] = num++;
                }
            }
        }
        return matrix; 
    }
}
