package backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 允许重复选择元素的组合_1 {

    /**
     * 题目：给定一个没有重复数字的正整数集合，请找出所有元素
     * 之和等于某个给定值的所有组合。同一个数字可以在组合中出现任
     * 意次。例如，输入整数集合[2，3，5]，元素之和等于8的组合有3
     * 个，分别是[2，2，2，2]、[2，3，3]和[3，5]。
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList();

        List<Integer> temp = new LinkedList();

        helper(candidates, target, result, temp, 0);

        return result;
    }

    public void helper(int[] candidates, int target, List<List<Integer>> result, List<Integer> temp, int index) {
        if (target == 0) {
            result.add(new ArrayList(temp));
        }else if (target > 0 && index < candidates.length) {
            // 不包括当前元素
            helper(candidates, target, result, temp, index + 1);

            temp.add(candidates[index]);

            // 包括当前元素
            helper(candidates, target - candidates[index], result, temp, index);

            temp.remove(temp.size() - 1);
        }
    }
}
