class Solution {
    public int maxProduct(int[] nums) {        
        int[] maxProduct = new int[nums.length];
        int[] minProduct = new int[nums.length];
        
        int max = nums[0];
        
        maxProduct[0] = nums[0];
        minProduct[0] = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            // minProduct当前最小的负数(用于处理负负得正的情况)
            int temp  = Math.max(nums[i], maxProduct[i-1] * nums[i]);
            maxProduct[i] = Math.max(temp, minProduct[i-1] * nums[i]);
            
            int temp2 = Math.min(nums[i], maxProduct[i-1] * nums[i]);
            minProduct[i] = Math.min(temp2, minProduct[i-1] * nums[i]);
            
            max = Math.max(max, maxProduct[i]);
        }
        
        return max;
    }
}
