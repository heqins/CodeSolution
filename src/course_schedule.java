import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Example 1:

Input: 2, [[1,0]] 
Output: true
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: 2, [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.
Note:

The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.

This is a simple method to detect a cycle using dfs. This method basically checks if a back edge exists in the graph. Its a simple 2 step process.
Step 1: construct a graph out of the prerequesite array.
Step 2 : perform dfs. While performing dfs, keep track of the current vertex being explored in the recursion in an array say currentStack. If we encounter a vertex which is already in the currentStack, it means there is a loop in the graph.

**/

public class course_schedule {
  // DFS
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<Integer> graph[] = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] currentStack = new boolean[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (isCycle(graph, visited, currentStack, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean isCycle(List<Integer> adj[], boolean[] visited, boolean[] currentStack, int start) {
      // currentStack-visiting
      // 为了保证内存不溢出，将visited[start]设为true，在后面进行条件判断提前结束循环
        visited[start] = true;
        currentStack[start] = true;
        Iterator<Integer> it = adj[start].iterator();
        while (it.hasNext()) {
            int temp = it.next();
            if (!visited[temp] && isCycle(adj, visited, currentStack, temp)) {
                return true;
            }else if (currentStack[temp]) {
                return true;
            }
        }
        currentStack[start] = false;
        return false;
    }

    public static void main(String[] args) {
        int num = 2;
        int[][] pre = new int[][]{{1,0}};
        System.out.println(new course_schedule().canFinish(num, pre));
    }
}
