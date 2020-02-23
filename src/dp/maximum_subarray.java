/**
 Given an integer array nums, find the contiguous subarray (containing at least one number) 
 
 which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
 **/

public class maximum_subarray {
    public int maxSubArray2(int[] nums) {
        // bruce force
        int maxSum = nums[0];
        for (int i = 0; i < nums.length ; i++){
            int tmpSum = 0; //recorde every step sum value
            for (int j = i; j < nums.length; j++){
                tmpSum += nums[j];
                maxSum = maxSum > tmpSum ? maxSum : tmpSum; // update MaxSum
            }
        }
        return maxSum;
    }

    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // maxSum可以看作是当前连续数组的和，每次都决定是否将当前数加入数组
            maxSum = Math.max(maxSum + nums[i], nums[i]);
            // dp存的是全局最大的
            dp[i] = Math.max(dp[i-1], maxSum);
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] test = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        maximum_subarray ms = new maximum_subarray();
        System.out.println(ms.maxSubArray(test));
    }
}
