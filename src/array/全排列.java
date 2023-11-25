package array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 全排列 {

    /**
     * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
     * 示例 1：
     *
     * 输入：nums = [1,2,3]
     * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     * 示例 2：
     *
     * 输入：nums = [0,1]
     * 输出：[[0,1],[1,0]]
     * 示例 3：
     *
     * 输入：nums = [1]
     * 输出：[[1]]
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList();

        List<Integer> temp = new LinkedList();

        int[] used = new int[nums.length];

        helper(nums, used, result, temp);

        return result;
    }

    public void helper(int[] candidates, int[] used, List<List<Integer>> result, List<Integer> temp) {
        if (temp.size() == candidates.length) {
            result.add(new ArrayList(temp));
            return;
        }

        if (temp.size() > candidates.length) {
            return;
        }

        for (int i = 0; i < candidates.length; i++) {
            if (used[i] == 1) {
                continue;
            }

            used[i] = 1;

            temp.add(candidates[i]);

            helper(candidates, used, result, temp);

            temp.remove(temp.size() - 1);

            used[i] = 0;
        }
    }

}
