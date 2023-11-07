package array;

public class 对角线遍历_2 {

    /**
     * 给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。
     */
    public int[] findDiagonalOrder(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;

        int[] result = new int[row * col];
        // 变换方向的次数
        int count = row + col - 1;
        int i = 0, j = 0;
        int index = 0;

        for (int x = 0; x < count; x++) {
            if (x % 2 == 0) {
                // 右上
                while (i >= 0 &&  j < col) {
                    result[index] = mat[i][j];
                    index++;
                    i--;
                    j++;
                }

                if (j < col) {
                    i++;
                }else {
                    i = i + 2;
                    j = j - 1;
                }
            }else {
                // 左下方向
                while (j >= 0 && i < row) {
                    result[index] = mat[i][j];
                    index++;
                    i++;
                    j--;
                }

                if (i < row) {
                    j++;
                }else {
                    j = j + 2;
                    i = i - 1;
                }
            }

        }

        return result;

    }
}
