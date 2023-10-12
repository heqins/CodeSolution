package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 子集2 {

    /**
     * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
     * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        List<Integer> temp = new ArrayList();

        Arrays.sort(nums);

        helper(res, temp, nums, 0);

        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> temp, int[] nums, int start) {
        // 和组合问题不同，进入递归就将当前路径驾到结果集里
        res.add(new ArrayList(temp));

        for (int i = start; i < nums.length; i++) {
            // 跳过重复的，为什么是i > start? 横向遍历的时候不希望有重复的起始点
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            temp.add(nums[i]);

            helper(res, temp, nums, i + 1);

            temp.remove(temp.size() - 1);
        }
    }
}
