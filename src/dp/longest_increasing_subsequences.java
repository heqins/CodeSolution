/**
Given an unsorted array of integers, find the length of longest increasing subsequence.

Example:

Input: [10,9,2,5,3,7,101,18]
Output: 4 
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 

Note:

    There may be more than one LIS combination, it is only necessary for you to return the length.
    Your algorithm should run in O(n2) complexity.

Follow up: Could you improve it to O(n log n) time complexity?

**/

public class longest_increasing_subsequences {
    /**
    首先来看一种动态规划 Dynamic Programming 的解法，这种解法的时间复杂度为 O(n2)，
    类似 brute force 的解法，维护一个一维 dp 数组，其中 dp[i] 表示以 nums[i] 为结尾的最长递增子串的长度，
    对于每一个 nums[i]，从第一个数再搜索到i，如果发现某个数小于 nums[i]，更新 dp[i]，更新方法为 dp[i] = max(dp[i], dp[j] + 1)，
    即比较当前 dp[i] 的值和那个小于 num[i] 的数的 dp 值加1的大小，就这样不断的更新 dp 数组，
    到最后 dp 数组中最大的值就是我们要返回的 LIS 的长度
    **/
    
    // https://leetcode.com/problems/longest-increasing-subsequence/solution/
    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < dp.length; i++) {
            int maxval = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxval = Math.max(maxval, dp[j]);
                }
            }
            dp[i] = maxval + 1;
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 0, 1, 6, 7, 4, 10};
        System.out.println(lengthOfLIS(nums));
    }
}
