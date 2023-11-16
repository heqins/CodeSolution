package graph;

import java.lang.reflect.Proxy;
import java.util.*;

public class 重建序列 {

    /**
     * 题目：长度为n的数组org是数字1～n的一个排列，seqs是若干
     * 序列，请判断数组org是否为可以由seqs重建的唯一序列。重建的序
     * 列是指seqs所有序列的最短公共超序列，即seqs中的任意序列都是
     * 该序列的子序列。
     * @param args
     */
    public static void main(String[] args) {
        int[] org = new int[]{4, 1, 5, 2, 6, 3};
        List<List<Integer>> seqs = new ArrayList<>();
        seqs.add(Arrays.asList(5, 2, 6, 3));
        seqs.add(Arrays.asList(4, 1, 5, 2));


        System.out.println(solve(org, seqs));
    }

    /**
     * 构建有向图和基于广度优先搜索进行拓扑排序的时间复杂度都是O（v+e）
     * @param org
     * @param seqs
     * @return
     */
    public static boolean solve(int[] org, List<List<Integer>> seqs) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> inDegrees = new HashMap<>();

        for (List<Integer> seq: seqs) {
            for (int num: seq) {
                if (num < 1 || num > org.length) {
                    return false;
                }

                graph.putIfAbsent(num, new HashSet<>());
                inDegrees.putIfAbsent(num, 0);
            }

            for (int i = 0; i < seq.size() - 1; i++) {
                int num1 = seq.get(i);
                int num2 = seq.get(i + 1);

                if (!graph.get(num1).contains(num2)) {
                    graph.get(num1).add(num2);
                    inDegrees.put(num2, inDegrees.get(num2) + 1);
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int num: inDegrees.keySet()) {
            if (inDegrees.get(num) == 0) {
                queue.add(num);
            }
        }

        List<Integer> result = new ArrayList<>();

        // 当队列中只有一个节点时，表示这个节点是当前可以处理的唯一节点，因为在拓扑排序中，
        // 我们应该一次处理一个入度为 0 的节点。所以，while (queue.size() == 1) 的作用是确保在每一轮排序中只处理一个节点，
        // 如果队列中有多个入度为 0 的节点，就返回 false，因为这意味着存在多个可能的排序结果，无法确定唯一的排列。
        while (queue.size() == 1) {
            int num = queue.poll();
            result.add(num);

            for (int neighbor: graph.get(num)) {
                inDegrees.put(neighbor, inDegrees.get(neighbor) - 1);

                if (inDegrees.get(neighbor) == 0) {
                    queue.add(neighbor);
                }
            }
        }

        int[] res = new int[result.size()];
        res = result.stream().mapToInt(i->i).toArray();
        return Arrays.equals(res, org);
    }
}
