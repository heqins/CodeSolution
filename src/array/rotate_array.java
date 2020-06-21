/**
Given an array, rotate the array to the right by k steps, where k is non-negative.

Follow up:

    Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
    Could you do it in-place with O(1) extra space?

 

Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]

Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]

 

Constraints:

    1 <= nums.length <= 2 * 10^4
    It's guaranteed that nums[i] fits in a 32 bit-signed integer.
    k >= 0


**/

import java.util.Arrays;

public class rotate_array {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
//        int[] res = new int[len];
//        for (int i = 0; i < nums.length; i++) {
//            res[(i + k) % len] = nums[i];
//        }
//
//        for (int j = 0; j < nums.length; j++) {
//            nums[j] = res[j];
//        }
        if (k > len) k = k % len;
        reverse(nums, 0, len - k - 1);
        reverse(nums, len - k, len - 1);
        reverse(nums, 0, len - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        rotate_array ra = new rotate_array();
        int[] test = new int[]{1, 2, 3, 4, 5, 6, 7};
        ra.rotate(test, 2);
        System.out.println(Arrays.toString(test));
    }
}
