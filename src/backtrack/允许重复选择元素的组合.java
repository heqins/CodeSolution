package backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 允许重复选择元素的组合 {

    /**
     * 题目：给定一个没有重复数字的正整数集合，请找出所有元素
     * 之和等于某个给定值的所有组合。同一个数字可以在组合中出现任
     * 意次。例如，输入整数集合[2，3，5]，元素之和等于8的组合有3
     * 个，分别是[2，2，2，2]、[2，3，3]和[3，5]。
     */
    public static void main(String[] args) {

    }

    public static List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        helper(result, new LinkedList<>(), nums, target, 0);

        return result;
    }

    public static void helper(List<List<Integer>> result, LinkedList<Integer> subset, int[] nums, int target, int index) {
        if (target == 0) {
            result.add(new ArrayList<>(subset));
            // target > 0 用于剪枝
        }else if (target > 0 && index < nums.length) {
            helper(result, subset, nums, target, index + 1);

            subset.add(nums[index]);
            helper(result, subset, nums, target - nums[index], index);

            subset.removeLast();
        }
    }
}
