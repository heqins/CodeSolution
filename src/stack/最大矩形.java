package stack;

import java.util.*;

public class 最大矩形 {

    /**
     * 给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
     *
     *
     *
     * 示例 1：
     *
     *
     * 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
     * 输出：6
     * 解释：最大矩形如上图所示。
     * 示例 2：
     *
     * 输入：matrix = []
     * 输出：0
     * 示例 3：
     *
     * 输入：matrix = [["0"]]
     * 输出：0
     * 示例 4：
     *
     * 输入：matrix = [["1"]]
     * 输出：1
     * 示例 5：
     *
     * 输入：matrix = [["0","0"]]
     * 输出：0
     * @param args
     */
    public int maximalRectangle(char[][] matrix) {
        // 将二维矩阵转为1维下的最大矩阵面积问题
        // 每行都新建一个数组，保存以每行为底的矩阵的高度
        List<int[]> allHeights = new ArrayList();
        int row = matrix.length, col = matrix[0].length;

        for (int i = row - 1; i >= 0; i--) {
            int[] height = new int[col + 2];

            for (int j = 0; j < col; j++) {
                int k = i;
                while (k >= 0 && matrix[k][j] == '1') {
                    height[j+1]++;
                    k--;
                }
            }

            allHeights.add(height);
        }

        int result = 0;
        for (int i = 0; i < allHeights.size(); i++) {
            Deque<Integer> stack = new ArrayDeque<>();
            System.out.println(Arrays.toString(allHeights.get(i)));

            for (int j = 0; j < allHeights.get(i).length; j++) {
                while (!stack.isEmpty() && allHeights.get(i)[stack.peek()] > allHeights.get(i)[j]) {
                    int cur = stack.pop();

                    result = Math.max(result, allHeights.get(i)[cur] * (j - stack.peek() - 1));
                }

                stack.push(j);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        最大矩形 d = new 最大矩形();
        char[][] matrix = new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        d.maximalRectangle(matrix);
    }
}
