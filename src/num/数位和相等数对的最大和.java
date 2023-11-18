package num;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class 数位和相等数对的最大和 {

    /**
     * 给你一个下标从 0 开始的数组 nums ，数组中的元素都是 正 整数。请你选出两个下标 i 和 j（i != j），且 nums[i] 的数位和 与  nums[j] 的数位和相等。
     *
     * 请你找出所有满足条件的下标 i 和 j ，找出并返回 nums[i] + nums[j] 可以得到的 最大值 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [18,43,36,13,7]
     * 输出：54
     * 解释：满足条件的数对 (i, j) 为：
     * - (0, 2) ，两个数字的数位和都是 9 ，相加得到 18 + 36 = 54 。
     * - (1, 4) ，两个数字的数位和都是 7 ，相加得到 43 + 7 = 50 。
     * 所以可以获得的最大和是 54 。
     * 示例 2：
     *
     * 输入：nums = [10,12,19,14]
     * 输出：-1
     * 解释：不存在满足条件的数对，返回 -1 。
     *
     *
     * 提示：
     *
     * 1 <= nums.length <= 105
     * 1 <= nums[i] <= 109
     */
    public int maximumSum(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int num: nums) {
            char[] chs = String.valueOf(num).toCharArray();

            int total = 0;
            for (char ch: chs) {
                total += (ch - '0');
            }

            PriorityQueue<Integer> queue = map.getOrDefault(total, new PriorityQueue<>((x, y) -> y - x));

            queue.offer(num);

            map.put(total, queue);
        }

        int result = Integer.MIN_VALUE;
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry: map.entrySet()) {
            PriorityQueue<Integer> queue = entry.getValue();
            if (queue.size() <= 1) {
                continue;
            }

            int first = queue.poll(), second = queue.poll();
            result = Math.max(result, first + second);
        }

        return result == Integer.MIN_VALUE ? -1 : result;
    }
}
