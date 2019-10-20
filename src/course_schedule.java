import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class course_schedule {
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