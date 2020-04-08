/**
Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

Example:

Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]

遍历数组元素，将每个桶里的元素还原，比如找到0，就标记0号桶，说明0元素出现过，货真价实没被篡改，
出现1就标记1号桶，这个元素出现了没被篡改。可以通过标记对应下标的桶为负，说明这个桶里的数字出现了，没被篡改。将所有的数组遍历之后，没被标记的桶对应的数字被篡改了，也就是没出现的。

**/

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; ++i) {
            int j = Math.abs(nums[i]) - 1; // 假设nums[0] = 0, nums[1] = 1...找到桶下标
            if (nums[j] > 0) { // 标记对应下标的桶为负，说明这个桶里的数字出现了，没被篡改
                nums[j] = -nums[j];
            }
        }
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > 0) { // 将所有的数组遍历之后，没被标记的说明被篡改了，也就是没出现的
                list.add(i + 1);
            }
        }
        return list;
    }
}
