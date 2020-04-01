/**
Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

Example 1:

Input: nums = [1, 5, 1, 1, 6, 4]
Output: One possible answer is [1, 4, 1, 5, 1, 6].
Example 2:

Input: nums = [1, 3, 2, 2, 3, 1]
Output: One possible answer is [2, 3, 1, 3, 1, 2].
Note:
You may assume all input has valid answer.

Follow Up:
Can you do it in O(n) time and/or in-place with O(1) extra space?
**/

class Solution {
    public void wiggleSort(int[] nums) {
        //sort the array
        Arrays.sort(nums);
        
        // find mid point of array
        int mid = (nums.length - 1 ) / 2;
        int right = nums.length - 1;
        
        //aux array to temp store the values
        int[] result = new int[right + 1];
        int counter = 0;
        
        // select values from two parts of the array and arrange them in aux array

        while (mid >= 0 || right > (nums.length - 1) / 2) {
            if (counter % 2 == 0) {
                result[counter] = nums[mid];
                mid--;
            }else {
                result[counter] = nums[right];
                right--;
            }
            counter++;
        }
        
        for (int i = 0; i < nums.length; i++) {
            nums[i] = result[i];
        }
    }
}
