package graph;

import java.util.LinkedList;
import java.util.Queue;

public class 朋友圈_2 {

    /**
     * 题目：假设一个班级中有n个学生。学生之间有些是朋友，有些
     * 不是。朋友关系是可以传递的。例如，A是B的直接朋友，B是C的直
     * 接朋友，那么A是C的间接朋友。定义朋友圈就是一组直接朋友或间
     * 接朋友的学生。输入一个n×n的矩阵M表示班上的朋友关系，如果
     * M[i][j]=1，那么学生i和学生j是直接朋友。请计算该班级中朋友圈
     * 的数目。
     *
     * @param args
     */
    public static void main(String[] args) {
        // Test case 1
        int[][] matrix1 = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };
        System.out.println("Test case 1: " + solve2(matrix1));  // Output: 2

        // Test case 2
        int[][] matrix2 = {
                {1, 1, 0},
                {1, 1, 1},
                {0, 1, 1}
        };
        System.out.println("Test case 2: " + solve2(matrix2));  // Output: 1
    }

    public static int solve(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int result = 0;
        boolean[] visited = new boolean[row];

        for (int i = 0; i < row; i++) {
            if (!visited[i]) {
                dfs(matrix, visited, i);
                result += 1;
            }
        }

        return result;
    }

    public static void helper(int[][] matrix, boolean[] visited, int i) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        visited[i] = true;

        while (!queue.isEmpty()) {
            int t = queue.poll();
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[t][j] == 1 && !visited[j]) {
                    queue.offer(j);
                    visited[j] = true;
                }
            }
        }
    }

    public static void dfs(int[][] matrix, boolean[] visited, int student) {
        visited[student] = true;
        for (int i = 0; i < matrix[student].length; i++) {
            if (matrix[student][i] == 1 && !visited[i]) {
                dfs(matrix, visited, i);
            }
        }
    }

    public static int solve2(int[][] matrix) {
        int[] fathers = new int[matrix.length];
        for (int i = 0; i < fathers.length; i++) {
            fathers[i] = i;
        }

        int count = matrix.length;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                if (matrix[i][j] == 1 && union(fathers, i, j)) {
                    count--;
                }
            }
        }

        return count;
    }

    public static boolean union(int[] fathers, int i, int j) {
        int fatherOfI = findFathers(fathers, i);
        int fatherOfJ = findFathers(fathers, j);

        if (fatherOfJ != fatherOfI) {
            fathers[fatherOfI] = fatherOfJ;
            return true;
        }

        return false;
    }

    public static int findFathers(int[] fathers, int i) {
        if (fathers[i] != i) {
            fathers[i] = findFathers(fathers, fathers[i]);
        }

        return fathers[i];
    }
}
