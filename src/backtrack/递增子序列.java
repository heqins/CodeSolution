package backtrack;

import java.util.ArrayList;
import java.util.List;

public class 递增子序列 {

    /**
     * 给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。
     *
     * 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
     */

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        List<Integer> temp = new ArrayList();

        helper(res, temp, nums, 0);

        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> temp, int[] nums, int start) {
        if (temp.size() >= 2) {
            res.add(new ArrayList(temp));
        }

        // 主要是避免生成重复元素,同一父节点下的同层上使用过的元素就不能再使用了
        int[] used = new int[201];

        for (int i = start; i < nums.length; i++) {
            if (temp.size() > 0) {
                if (nums[i] < temp.get(temp.size() - 1)) {
                    continue;
                }
            }

            // 数组
            if (used[nums[i] + 100] == 1) {
                continue;
            }

            used[nums[i] + 100] = 1;

            temp.add(nums[i]);

            helper(res, temp, nums, i + 1);

            temp.remove(temp.size() - 1);
        }
    }
}
