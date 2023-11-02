package matrix;

public class 搜索二维矩阵2_1 {

    /**
     * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
     *
     * 每行的元素从左到右升序排列。
     * 每列的元素从上到下升序排列。
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        if (rows == 0) {
            return false;
        }

        // 从右上开始，利用了左边的比当前小，下面的比当前大的性质，用来确定搜索方向
        int i = 0;
        int j = cols - 1;

        while (i < rows && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            }

            if (matrix[i][j] > target) {
                j--;
                continue;
            }

            if (matrix[i][j] < target) {
                i++;
            }
        }

        return false;
    }
}
