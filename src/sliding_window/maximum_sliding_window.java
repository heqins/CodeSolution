/**
Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.

Follow up:
Could you solve it in linear time?

Example:

Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
Output: [3,3,5,5,6,7] 
Explanation: 

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7

 

Constraints:

    1 <= nums.length <= 10^5
    -10^4 <= nums[i] <= 10^4
    1 <= k <= nums.length


**/


class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
    int[] result = new int[len - k + 1];
    if(nums.length == 0) return new int[0];
    Queue<Integer> queue = new PriorityQueue<Integer>(len, Collections.reverseOrder());
    
    for(int i = 0; i < k; i ++){
        queue.add(nums[i]);
    }
    result[0] = queue.peek();
    for(int i = k; i < len; i ++){
        queue.remove(nums[i - k]);
        queue.add(nums[i]);
        result[i - k + 1] = queue.peek();
    }
   
        return result;
    }
}
