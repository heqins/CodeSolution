package array;

public class 分隔等和子集 {

    /**
     * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
     */

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num: nums) {
            sum += num;
        }

        // 是总和能整除2，而不是数组个数能整除
        if (sum % 2 != 0) {
            return false;
        }

        int targetSum = sum / 2;

        // 是否能够前i个数使得数组和为j
        boolean[][] dp = new boolean[nums.length][targetSum + 1];
        dp[0][0] = true;

        if (nums[0] <= targetSum) {
            dp[0][nums[0]] = true;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= targetSum; j++) {
                dp[i][j] = dp[i - 1][j] || (j > nums[i] ? dp[i - 1][j - nums[i]] : false);
            }
        }

        return dp[nums.length - 1][targetSum];
    }

    public boolean canPartition2(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return false; // 数组长度小于2不能分割成两个子集
        }

        int totalSum = 0;
        int maxNum = 0;

        // 计算数组元素总和和最大元素值
        for (int num : nums) {
            totalSum += num;
            maxNum = Math.max(maxNum, num);
        }

        // 如果总和是奇数，不能分割成两个相等的子集
        if (totalSum % 2 != 0) {
            return false;
        }

        int targetSum = totalSum / 2;

        // 如果最大元素大于目标和，也不能分割成两个相等的子集
        if (maxNum > targetSum) {
            return false;
        }

        // 创建一维DP数组
        boolean[] dp = new boolean[targetSum + 1];

        // 初始化DP数组
        dp[0] = true;

        // 填充DP数组
        for (int i = 0; i < n; i++) {
            for (int j = targetSum; j >= nums[i]; j--) {
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }

        // 返回结果
        return dp[targetSum];
    }

}
