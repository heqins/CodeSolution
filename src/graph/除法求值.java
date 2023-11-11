package graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 除法求值 {

    /**
     * 给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，其中 equations[i] = [Ai, Bi] 和 values[i] 共同表示等式 Ai / Bi = values[i] 。每个 Ai 或 Bi 是一个表示单个变量的字符串。
     *
     * 另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，请你根据已知条件找出 Cj / Dj = ? 的结果作为答案。
     *
     * 返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。如果问题中出现了给定的已知条件中没有出现的字符串，也需要用 -1.0 替代这个答案。
     *
     * 注意：输入总是有效的。你可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。
     *
     * 注意：未在等式列表中出现的变量是未定义的，因此无法确定它们的答案。
     *
     *
     *
     * 示例 1：
     *
     * 输入：equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
     * 输出：[6.00000,0.50000,-1.00000,1.00000,-1.00000]
     * 解释：
     * 条件：a / b = 2.0, b / c = 3.0
     * 问题：a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
     * 结果：[6.0, 0.5, -1.0, 1.0, -1.0 ]
     * 注意：x 是未定义的 => -1.0
     */
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Double> num = new HashMap<>();
        Map<String, String> parents = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            union(parents, num, equations, equations.get(i).get(0), equations.get(i).get(1), values[i]);
        }

        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String e = queries.get(i).get(0);
            String f = queries.get(i).get(1);

            if (!parents.containsKey(e) || !parents.containsKey(f)) {
                result[i] = -1.0;
                continue;
            }

            if (e.equals(f)) {
                result[i] = 1.0;
                continue;
            }

            String rootOfe = findRoot(parents, e);
            String rootOfF = findRoot(parents, f);

            if (!rootOfe.equals(rootOfF)) {
                result[i] = -1.0;
                continue;
            }

            result[i] = pm(parents, num, f) / pm(parents, num, e);
        }

        return result;
    }

    public void union(Map<String, String> parents, Map<String, Double> num, List<List<String>> equations, String parent, String child, double value) {
        add(parents, num, parent);
        add(parents, num, child);

        String rootOfParent = findRoot(parents, parent);
        String rootOfChild = findRoot(parents, child);

        if (!rootOfChild.equals(rootOfParent)) {
            parents.put(rootOfChild, rootOfParent);
            num.put(rootOfChild, value * (pm(parents, num, parent) / pm(parents, num, child)));
        }
    }

    private double pm(Map<String, String> parents, Map<String, Double> num, String x) {
        double temp = 1.0;
        while (!parents.get(x).equals(x)) {
            temp *= num.get(x);
            x = parents.get(x);
        }

        return temp;
    }

    private String findRoot(Map<String, String> parents, String x) {
        while (!parents.get(x).equals(x)) {
            x = parents.get(x);
        }

        return x;
    }

    private void add(Map<String,String> parents, Map<String, Double> num, String x) {
        if (!parents.containsKey(x)) {
            parents.put(x, x);
            num.put(x, 1.0);
        }
    }
}
