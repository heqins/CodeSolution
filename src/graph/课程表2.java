package graph;

import java.util.*;

public class 课程表2 {

    /**
     * 现在你总共有 numCourses 门课需要选，记为 0 到 numCourses - 1。给你一个数组 prerequisites ，其中 prerequisites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修 bi 。
     *
     * 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示：[0,1] 。
     * 返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。如果不可能完成所有课程，返回 一个空数组 。
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] in = new int[numCourses];

        // graph是用于保存当前节点想通的相邻节点，用于后续减少出度
        Map<Integer, List<Integer>> graph = new HashMap();

        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList());
        }

        for (int[] pre: prerequisites) {
            graph.get(pre[1]).add(pre[0]);
            in[pre[0]]++;
        }

        Queue<Integer> queue = new LinkedList();
        for (int i = 0; i < numCourses; i++) {
            if (in[i] == 0) {
                queue.add(i);
            }
        }

        List<Integer> result = new ArrayList();

        while (!queue.isEmpty()) {
            int course = queue.poll();

            result.add(course);

            for (int neighbor: graph.get(course)) {
                in[neighbor]--;

                if (in[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        return result.size() == numCourses ? result.stream().mapToInt(i -> i).toArray() : new int[]{};
    }
}
