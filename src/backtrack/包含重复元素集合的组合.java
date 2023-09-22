package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 包含重复元素集合的组合 {

    /**
     * 题目：给定一个可能包含重复数字的整数集合，请找出所有元
     * 素之和等于某个给定值的所有组合。输出中不得包含重复的组合。
     * 例如，输入整数集合[2，2，2，4，3，3]，元素之和等于8的组合有
     * 2个，分别是[2，2，4]和[2，3，3]。
     * @param args
     */
    public static void main(String[] args) {

    }

    public static List<List<Integer>> find(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        helper(result, new LinkedList<>(), nums, 0, target);

        return result;
    }

    public static void helper(List<List<Integer>> result, LinkedList<Integer> subset, int[] nums, int index, int target) {
        if (target == 0) {
            result.add(new LinkedList<>(subset));
        }else if (target > 0 && index < nums.length) {
            helper(result, subset, nums, findNext(nums, index), target);

            subset.add(nums[index]);
            helper(result, subset, nums, index + 1, target - nums[index]);

            subset.removeLast();
        }
    }

    private static int findNext(int[] nums, int index) {
        int next = index;
        while (next < nums.length && nums[index] == nums[next]) {
            next++;
        }

        return next;
    }
}
