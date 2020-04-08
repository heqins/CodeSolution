/**
这道题给了我们 n+1 个数，所有的数都在 [1, n] 区域内，首先让证明必定会有一个重复数，
这不禁让博主想起了小学华罗庚奥数中的抽屉原理(又叫鸽巢原理)，即如果有十个苹果放到九个抽屉里，
如果苹果全在抽屉里，则至少有一个抽屉里有两个苹果，这里就不证明了，直接来做题吧。题目要求不能改变原数组，
即不能给原数组排序，又不能用多余空间，那么哈希表神马的也就不用考虑了，又说时间小于 O(n2)，
也就不能用 brute force 的方法，那也就只能考虑用二分搜索法了，在区间 [1, n] 中搜索，
首先求出中点 mid，然后遍历整个数组，统计所有小于等于 mid 的数的个数，如果个数小于等于 mid，
则说明重复值在 [mid+1, n] 之间，反之，重复值应在 [1, mid-1] 之间，然后依次类推，
直到搜索完成，此时的 low 就是我们要求的重复值，参见代码如下：
**/

/**
Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

Example 1:

Input: [1,3,4,2,2]
Output: 2
Example 2:

Input: [3,1,3,4,2]
Output: 3
Note:

You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
Your runtime complexity should be less than O(n2).
There is only one duplicate number in the array, but it could be repeated more than once.
**/
