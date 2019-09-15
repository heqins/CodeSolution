package DataStructure;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class yingyong_02_07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入行数：");
        int n = sc.nextInt();

        int[][] triangle = new int[n][];

        for (int i = 0; i < triangle.length; i++) {
            triangle[i] = new int[i + 1];

            for (int j = 0; j < triangle[i].length; j++){
                if (j == 0 || i == 0 || i == j) {
                    triangle[i][j] = 1;
                }else {
                    triangle[i][j] = triangle[i - 1][j] + triangle[i - 1][j - 1];
                }
                System.out.print(triangle[i][j] + " ");
            }
            System.out.println();
        }

        Queue<Integer> q = new PriorityQueue<>();
        q.add(1);

        for (int i = 2; i < n; i++) {
            q.add(1);
            for (int j = 1; j <= n - 2; j++) {
                int temp = q.poll();

            }
        }
    }
}
