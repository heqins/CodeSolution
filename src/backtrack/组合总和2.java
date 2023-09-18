package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 组合总和2 {
    /**
     * 给定一个可能有重复数字的整数数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     *
     * candidates 中的每个数字在每个组合中只能使用一次，解集不能包含重复的组合。
     */
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList();
        List<Integer> temp = new ArrayList();

        Arrays.sort(candidates);

        helper(res, temp, candidates, target, 0);

        return res;
    }

    public static void helper(List<List<Integer>> res, List<Integer> temp, int[] candidates, int target, int start) {
        if (target < 0) {
            return;
        }

        if (target == 0) {
            res.add(new ArrayList(temp));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // 剪枝
            if ( candidates[i] > target) {
                break;
            }

            // 用于检查当前循环中的候选数字是否与前一个候选数字相同
            if (i > start) {
                if (candidates[i] == temp.get(temp.size() - 1)) {
                    continue;
                }
            }

            temp.add(candidates[i]);

            helper(res, temp, candidates, target - candidates[i], i + 1);

            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{10,1,2,7,6,1,5};
        combinationSum2(candidates, 8);
    }
}
