package array;

import java.util.ArrayList;
import java.util.List;

public class 螺旋矩阵 {

    /**
     * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
     */
    // 时间复杂度O(MN)
    public List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        List<Integer> result = new ArrayList();
        if (row == 0 || col == 0) {
            return result;
        }

        int rowLow = 0, rowHigh = row - 1, colLeft = 0, colRight = col - 1;
        while (rowLow <= rowHigh && colLeft <= colRight) {
            for (int i = colLeft; i <= colRight; i++) {
                result.add(matrix[rowLow][i]);
            }

            rowLow++;

            for (int i = rowLow; i <= rowHigh; i++) {
                result.add(matrix[i][colRight]);
            }

            colRight--;

            // todo:
            if (rowLow <= rowHigh) {
                for (int i = colRight; i >= colLeft; i--) {
                    result.add(matrix[rowHigh][i]);
                }
            }


            rowHigh--;

            if (colLeft <= colRight) {
                for (int i = rowHigh; i >= rowLow; i--) {
                    result.add(matrix[i][colLeft]);
                }
            }

            colLeft++;
        }

        return result;
    }
}
