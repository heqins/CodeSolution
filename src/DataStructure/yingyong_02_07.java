package DataStructure;

import org.w3c.dom.ls.LSOutput;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class yingyong_02_07 {
    // 可以从杨辉三角可以知道，它的每个数等于它上方两数之和、每行第一个数和最后一个数都是1
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

        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        q.offer(1);
        System.out.println(1);
        for (int i=1; i<n; i++)
        {
            q.offer(0);
            for (int j=0; j<=i; j++)
            {
                int v = q.poll();
                v += q.peek();
                q.offer(v);
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }
}
