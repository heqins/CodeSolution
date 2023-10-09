package graph;

import java.util.Arrays;

public class 多余的边 {

    /**
     * 题目：树可以看成无环的无向图。在一个包含n个节点（节点标
     * 号为从1到n）的树中添加一条边连接任意两个节点，这棵树就会变
     * 成一个有环的图。给定一个在树中添加了一条边的图，请找出这条
     * 多余的边（用这条边连接的两个节点表示）。输入的图用一个二维
     * 数组edges表示，数组中的每个元素是一条边的两个节点[u，v]（u
     * ＜v）。如果有多个答案，请输出在数组edges中最后出现的边。
     * @param args
     */
    public static void main(String[] args) {
        int[][] edges = new int[][]{{1, 2}, {1,3}, {2, 4}, {3, 4}, {2, 5}};
        System.out.println(Arrays.toString(solve(edges)));
    }

    public static int[] solve(int[][] edges) {
        int maxVertex = 0;
        for (int[] edge: edges) {
            maxVertex = Math.max(maxVertex, edge[0]);
            maxVertex = Math.max(maxVertex, edge[1]);
        }

        int[] fathers = new int[maxVertex];
        for (int i = 0; i < maxVertex; i++) {
            fathers[i] = i;
        }

        for (int[] edge: edges) {
            // 如果没有公共根节点
            if (!union(fathers, edge[0], edge[1])) {
                return edge;
            }
        }

        return new int[2];
    }

    // 合并方法返回的是什么？true：有公共父节点 false：没有公共父节点
    public static boolean union(int[] fathers, int x, int y) {
        int fatherOfI = findFathers(fathers, x);
        int fatherOfJ = findFathers(fathers, y);

        if (fatherOfI != fatherOfJ) {
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
