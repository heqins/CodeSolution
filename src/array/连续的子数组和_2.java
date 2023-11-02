package array;

import java.util.HashMap;

public class 连续的子数组和_2 {

    /**
     * 给你一个整数数组 nums 和一个整数 k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组：
     *
     * 子数组大小 至少为 2 ，且
     * 子数组元素总和为 k 的倍数。
     * 如果存在，返回 true ；否则，返回 false 。
     *
     * 如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。0 始终视为 k 的一个倍数。
     */

    public static void main(String[] args) {
        checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6);
    }

    public static boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        if (n < 2) {
            return false; // 子数组至少为2
        }

        HashMap<Integer, Integer> modMap = new HashMap<>();
        modMap.put(0, -1); // 初始化模数0对应的索引为-1，用于处理前两个元素的累积和

        // [1, 2, 3, 4]
        // [1, 3, 6, 10]
        int prefixSum = 0;
        for (int i = 0; i < n; i++) {
            prefixSum += nums[i];

            if (k != 0) {
                // (y - x) % k == 0 -> y % k == 0; x % k == 0
                prefixSum %= k;
            }

            if (modMap.containsKey(prefixSum)) {
                int prevIndex = modMap.get(prefixSum);
                if (i - prevIndex >= 2) {
                    return true;
                }
            } else {
                modMap.put(prefixSum, i);
            }
        }

        return false;
    }

}
