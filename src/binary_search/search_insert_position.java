/**
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Example 1:

Input: [1,3,5,6], 5
Output: 2
Example 2:

Input: [1,3,5,6], 2
Output: 1
Example 3:

Input: [1,3,5,6], 7
Output: 4
Example 4:

Input: [1,3,5,6], 0
Output: 0
**/

/**
第二类： 查找第一个不小于目标值的数，可变形为查找最后一个小于目标值的数

这是比较常见的一类，因为我们要查找的目标值不一定会在数组中出现，也有可能是跟目标值相等的数在数组中并不唯一，

而是有多个，那么这种情况下 nums[mid] == target 这条判断语句就没有必要存在。比如在数组 [2, 4, 5, 6, 9] 中查找数字3，

就会返回数字4的位置；在数组 [0, 1, 1, 1, 1] 中查找数字1，就会返回第一个数字1的位置。我们可以使用如下代码：
**/
public class search_insert_position {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        
        return right;
    }

    public static void main(String[] args) {
        int[] test = new int[]{1,3,5,6};
        int target = 2;
        search_insert_position sip = new search_insert_position();
        System.out.println(sip.searchInsert(test, target));
    }
}
