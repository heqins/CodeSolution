package tree;

import java.util.*;

public class Kill_Process {

    /**
     * Description,
     * Given n processes, each process has a unique PID (process id) and its PPID (parent process id).
     *
     * Each process only has one parent process, but may have one or more children processes. This is just like a tree structure. Only one process has PPID that is 0, which means this process has no parent process. All the PIDs will be distinct positive integers.
     *
     * We use two list of integers to represent a list of processes, where the first list contains PID for each process and the second list contains the corresponding PPID.
     *
     * Now given the two lists, and a PID representing a process you want to kill, return a list of PIDs of processes that will be killed in the end. You should assume that when a process is killed, all its children processes will be killed. No order is required for the final answer.
     *
     * Example 1:
     *
     * Input:
     * pid =  [1, 3, 10, 5]
     * ppid = [3, 0, 5, 3]
     * kill = 5
     * Output: [5,10]
     * Explanation:
     *            3
     *          /   \
     *         1     5
     *              /
     *             10
     * Kill 5 will also kill 10.
     */
    public static void main(String[] args) {
        List<Integer> pid = List.of(1, 3, 10, 5);
        List<Integer> ppid = List.of(3, 0, 5, 3);

        Kill_Process  k = new Kill_Process();
        k.killProcess(pid, ppid, 5);

    }
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        List<Integer> result = new ArrayList();


        Map<Integer, List<Integer>> map = new HashMap();

        for (int i = 0; i < ppid.size(); i++) {
            List<Integer> childs = map.getOrDefault(ppid.get(i), new ArrayList());
            childs.add(pid.get(i));

            map.put(ppid.get(i), childs);
        }

        helper(map, kill, result);

        result.add(kill);

        return result;
    }

    public void helper(Map<Integer, List<Integer>> map, Integer kill, List<Integer> result) {
        List<Integer> childs = map.get(kill);
        if (childs == null) {
            return;
        }

        for (Integer child: childs) {
            result.add(child);

            helper(map, child, result);
        }
    }
}
