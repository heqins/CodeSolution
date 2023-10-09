package array;

import java.util.HashSet;
import java.util.Set;

public class 最长连续序列 {

    /**
     * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
     * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
     */
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        // 关键是题目要求的是数字连续
        Set<Integer> set = new HashSet();
        for (int num: nums) {
            set.add(num);
        }

        int result = 0;
        for (int num: nums) {
            // 为了避免重复计算连续长度
            if (!set.contains(num - 1)) {
                int currentStreak = 1;
                int cur = num;

                while (set.contains(cur + 1)) {
                    currentStreak += 1;
                    cur += 1;
                }

                result = Math.max(result, currentStreak);
            }
        }

        return result;
    }
}
