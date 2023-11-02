package backtrack;

import java.util.ArrayList;
import java.util.List;

public class 组合总和_2 {

    /**
     * 给定一个无重复元素的正整数数组 candidates 和一个正整数 target ，
     * 找出 candidates 中所有可以使数字和为目标数 target 的唯一组合。
     * candidates 中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是不同的。
     * 对于给定的输入，保证和为 target 的唯一组合数少于 150 个。
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList();

        List<Integer> temp = new ArrayList();

        helper(result, temp, candidates, target, 0);

        return result;
    }

    public void helper(List<List<Integer>> result, List<Integer> temp,
                       int[] candidates, int target, int index) {
        if (target == 0) {
            result.add(new ArrayList(temp));

            return;
        }

        if (index >= candidates.length) {
            return;
        }

        if (target < 0) {
            return;
        }

        // 不选当前元素
        helper(result, temp, candidates, target, index + 1);

        // 选择当前元素
        temp.add(candidates[index]);

        helper(result, temp, candidates, target - candidates[index], index);

        temp.remove(temp.size() - 1);
    }
}
