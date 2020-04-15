/**
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example 1:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:

Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
**/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class spiral_matrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if (matrix.length == 0) {
            return res;
        }

        int rowBegin = 0;
        int colBegin = 0;
        int rowEnd = matrix.length - 1;
        int colEnd = matrix[0].length - 1;

        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            for (int i = colBegin; i <= colEnd; i++) {
                res.add(matrix[rowBegin][i]);
            }

            rowBegin++;

            for (int i = rowBegin; i <= rowEnd; i++) {
                res.add(matrix[i][colEnd]);
            }

            colEnd--;

            if (rowBegin <= rowEnd) {
                for (int i = colEnd; i >= colBegin; i--) {
                    res.add(matrix[rowEnd][i]);
                }
            }

            rowEnd--;

            if (colBegin <= colEnd) {
                for (int i = rowEnd; i >= rowBegin; i--) {
                    res.add(matrix[i][colBegin]);
                }
            }

            colBegin++;
        }

        return res;
    }
}
