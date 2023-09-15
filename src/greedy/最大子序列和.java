package greedy;

public class 最大子序列和 {

    /**
     * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     *
     * 子数组 是数组中的一个连续部分。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 输出：6
     * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(solve(nums));
    }

    /**
     * 贪心：寻找局部最优解，如果当前子序列和小于0，则重置；如果只是数字小于0，还不需要重置，尝试加入子序列
     * @param nums
     * @return
     */
    public static int solve(int[] nums) {
        int result = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            result = Math.max(result, sum);

            if (sum < 0) {
                sum = 0;
            }
        }

        return result;
    }
}
