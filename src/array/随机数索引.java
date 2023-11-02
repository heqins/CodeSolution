package array;

import java.util.Random;

public class 随机数索引 {

    /**
     * 给你一个可能含有 重复元素 的整数数组 nums ，请你随机输出给定的目标数字 target 的索引。你可以假设给定的数字一定存在于数组中。
     *
     * 实现 Solution 类：
     *
     * Solution(int[] nums) 用数组 nums 初始化对象。
     * int pick(int target) 从 nums 中选出一个满足 nums[i] == target 的随机索引 i 。如果存在多个有效的索引，则每个索引的返回概率应当相等。
     */
    private int[] nums;

    public 随机数索引(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {
        Random r = new Random();

        // 蓄水池算法：每次以1/n的概率保留蓄水池中的数，对于每个数取到的概率是相同的

        int n = 0;
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                n++;
                // 每次以1/n的概率留下该数，这里的蓄水池大小是nums里值=target的数量
                if (r.nextInt() % n == 0) {
                    result = i;
                }
            }
        }

        return result;
    }
}
