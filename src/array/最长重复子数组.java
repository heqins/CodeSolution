package array;

public class 最长重复子数组 {

    /**
     * 给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。
     */
    public int findLength(int[] nums1, int[] nums2) {
        int result = 0;
        // dp[i][j] 表示 nums1[0...i] 和 nums2[0...j] 的最长公共子数组
        // dp[i][j] = dp[i - 1][j - 1] + 1

        int[][] dp = new int[nums1.length + 1][nums2.length + 1];

        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    result = Math.max(result, dp[i][j]);
                }
            }
        }

        return result;
    }
}
