package backtrack;

import java.util.LinkedList;
import java.util.List;

public class 包含k个元素的组合 {

    /**
     * 题目：输入n和k，请输出从1到n中选取k个数字组成的所有组
     * 合。例如，如果n等于3，k等于2，将组成3个组合，分别是[1，2]、
     * [1，3]和[2，3]。
     * @param args
     */
    public static List<List<Integer>> find(int n, int k) {
        List<List<Integer>> result = new LinkedList<>();

        helper(result, new LinkedList<>(), n, k, 1);

        return result;
    }

    public static void helper(List<List<Integer>> result, LinkedList<Integer> subset, int n, int k, int index) {
        if (subset.size() == k) {
            result.add(new LinkedList<>(subset));
        }else if (index <= n) {
            // 关键是这里，每次可以不选择当前index的元素
            helper(result, subset, n, k, index + 1);

            // 如果加了，后面回溯要去掉当前元素
            subset.add(index);

            helper(result, subset, n, k, index + 1);

            subset.removeLast();
        }
    }
}
