package graph;

import java.util.*;

public class 课程顺序 {

    /**
     * 题目：n门课程的编号为0～n-1。输入一个数组
     * prerequisites，它的每个元素prerequisites[i]表示两门课程的先
     * 修顺序。如果prerequisites[i]=[ai，bi]，那么必须先修完bi才能
     * 修ai。请根据总课程数n和表示先修顺序的prerequisites得出一个
     * 可行的修课序列。如果有多个可行的修课序列，则输出任意一个可
     * 行的序列；如果没有可行的修课序列，则输出空序列。
     * @param args
     */
    public static void main(String[] args) {

    }

    public static int[] solve(int[][] nums, int numCourses) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new LinkedList<>());
        }

        int[] inDegrees = new int[numCourses];

        for (int[] edge: nums) {
            graph.get(edge[1]).add(edge[0]);
            inDegrees[edge[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0) {
                queue.add(i);
            }
        }

        List<Integer> order = new ArrayList<>();
        while (!queue.isEmpty()) {
            int course = queue.poll();
            order.add(course);

            for (int neighbor: graph.get(course)) {
                inDegrees[neighbor]--;
                if (inDegrees[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        return order.size() == numCourses ? order.stream().mapToInt(i -> i).toArray() : new int[0];
    }
}
