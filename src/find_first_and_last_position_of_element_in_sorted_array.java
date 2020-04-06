/**
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
**/

public class find_first_and_last_position_of_element_in_sorted_array {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            }else if (nums[mid] < target){
                left = mid + 1;
            }
            else {
                int[] res = new int[]{0, 0};
                if (nums[left] == target) {
                    res[0] = target;
                }
                if (nums[right] == target) {
                    res[1] = target;
                }

                for (int i = mid; i <= right + 1; i++) {
                    if (nums[i] != target) {
                        res[1] = i - 1;
                        break;
                    }
                }
                for (int i = mid; i >= left - 1; i--) {
                    if (nums[i] != target) {
                        res[0] = i + 1;
                        break;
                    }
                }
                return res;
            }
        }
        return new int[]{-1, 1};
    }
}
