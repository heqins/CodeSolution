package array;

import java.util.Deque;
import java.util.LinkedList;

public class 和至少为K的最短子数组 {

    /**
     * 给你一个整数数组 nums 和一个整数 k ，找出 nums 中和至少为 k 的 最短非空子数组 ，
     * 并返回该子数组的长度。如果不存在这样的 子数组 ，返回 -1 。
     * 子数组 是数组中 连续 的一部分。
     */
    // 滑动窗口
    public int minSubArrayLen(int s, int[] nums) {
        int left = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            // 注意这里使用while，每次更新 i（起始位置），并不断比较子序列是否符合条件
            while (sum >= s) {
                // 不要以为for里放一个while就以为是O(n^2)啊， 主要是看每一个元素被操作的次数，
                // 每个元素在滑动窗后进来操作一次，出去操作一次，每个元素都是被操作两次，所以时间复杂度是 2 × n 也就是O(n)。
                // 窗口就是 满足其和 ≥ s 的长度最小的 连续 子数组。
                // 窗口的起始位置如何移动：如果当前窗口的值大于s了，窗口就要向前移动了（也就是该缩小了）。
                // 窗口的结束位置如何移动：窗口的结束位置就是遍历数组的指针，也就是for循环里的索引。
                result = Math.min(result, right - left + 1);
                sum -= nums[left++];
            }
        }
        // 如果result没有被赋值的话，就返回0，说明没有符合条件的子序列
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    public static void main(String[] args) {
        shortestSubarray(new int[]{84, -37, 32, 40, 95}, 167);
    }

    public static int shortestSubarray(int[] nums, int k) {
        int result = nums.length + 1;
        Deque<Integer> queue = new LinkedList();

        int[] preSum = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        for (int i = 0; i <= nums.length; i++) {
            while (!queue.isEmpty() && preSum[i] - preSum[queue.getFirst()] >= k) {
                result = Math.min(result, i - queue.pollFirst());
            }

            // 当队列中的索引对应的位置的前缀和是递增的时候，我们有更高的机会找到满足条件的子数组，
            // 因为这意味着这些索引对应的子数组的和是不断增加的，
            // 可能会达到或超过 k。如果队列尾部的索引所对应的位置的前缀和小于当前位置的前缀和，
            // 那么它们之间的子数组是不满足和至少为 k 的条件的，因此可以将队列尾部的索引出队，以便继续寻找更短的子数组。
             while (!queue.isEmpty() && preSum[i] - preSum[queue.getLast()] <= 0) {
                 queue.pollLast();
             }

            queue.addLast(i);
        }

        return result == nums.length + 1 ? -1 : result;
    }
}
