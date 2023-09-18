package backtrack;

import java.util.ArrayList;
import java.util.List;

public class 全排列 {

    /**
     * 给定一个不含重复数字的整数数组 nums ，返回其 所有可能的全排列 。可以 按任意顺序 返回答案。
     */
    public List<List<Integer>> permute(int[] nums) {
        int[] used = new int[21];

        List<List<Integer>> res = new ArrayList();

        List<Integer> temp = new ArrayList();

        helper(res, temp, used, nums, nums.length);

        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> temp,
                       int[] used, int[] nums, int targetLength) {
        if (temp.size() > targetLength) {
            return;
        }

        if (temp.size() == targetLength) {
            res.add(new ArrayList(temp));
            return;
        }

        for (int i = 0; i < targetLength; i++) {
            if (used[nums[i] + 10] == 1) {
                continue;
            }

            used[nums[i] + 10] = 1;

            temp.add(nums[i]);

            helper(res, temp, used, nums, targetLength);

            used[nums[i] + 10] = 0;

            temp.remove(temp.size() - 1);
        }
    }
}
