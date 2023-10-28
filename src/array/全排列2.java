package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 全排列2 {

    /**
     * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [1,1,2]
     * 输出：
     * [[1,1,2],
     *  [1,2,1],
     *  [2,1,1]]
     * 示例 2：
     *
     * 输入：nums = [1,2,3]
     * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList();

        List<Integer> temp = new ArrayList();

        int[] used = new int[nums.length];

        Arrays.sort(nums);

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

        for (int i = 0; i < nums.length; i++) {
            if (used[i] == 1) {
                continue;
            }

            // 对于排序后的数组，如果i-1没有访问到，但是i和i-1元素却相等，说明当前分支继续下去会产生重复序列，需要剪掉
            if (i > 0 && used[i - 1] != 1 && nums[i] == nums[i - 1]) {
                continue;
            }

            used[i] = 1;

            temp.add(nums[i]);

            helper(res, temp, used, nums, targetLength);

            used[i] = 0;

            temp.remove(temp.size() - 1);
        }
    }
}
