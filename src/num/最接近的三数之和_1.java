package num;

import java.util.Arrays;

public class 最接近的三数之和_1 {

    /**
     * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
     *
     * 返回这三个数的和。
     *
     * 假定每组输入只存在恰好一个解。
     */
    public int threeSumClosest(int[] nums, int target) {
        int min = Integer.MAX_VALUE;
        int ans = 0;
        // 排序+三指针
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int start = i + 1;
            int end = nums.length - 1;

            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];

                if (sum > target) {
                    end--;
                }else if (sum < target){
                    start++;
                }else {
                    return sum;
                }

                if (Math.abs(target - sum) < min) {
                    min = Math.abs(target - sum);
                    ans = sum;
                }
            }
        }

        return ans;
    }
}
