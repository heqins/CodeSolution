package backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 所有子集 {

    /**
     * 题目：输入一个不含重复数字的数据集合，请找出它的所有子
     * 集。例如，数据集合[1，2]有4个子集，分别是[]、[1]、[2]和[1，
     * 2]。
     * @param args
     */
    public static void main(String[] args) {

    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, 0, result, new LinkedList<>());

        return result;
    }

    private static void helper(int[] nums, int index, List<List<Integer>> result, LinkedList<Integer> subset) {
        if (index == nums.length) {
            result.add(new ArrayList<>(subset));
        }else if (index < nums.length) {
            // 不选择加入当前元素
            helper(nums, index + 1, result, subset);
            // 选择加入当前元素
            subset.add(nums[index]);
            helper(nums, index + 1, result, subset);
            // 回溯到父节点，需要清除状态
            subset.removeLast();
        }
    }
}
