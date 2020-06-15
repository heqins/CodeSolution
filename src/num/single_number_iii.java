/**
Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

Example:

Input:  [1,2,1,3,2,5]
Output: [3,5]
Note:

The order of the result is not important. So in the above example, [5, 3] is also correct.
Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
**/

/**
我明白了，假设单独出现的两个数分别是a 和 b。其实到最后，diff的二进制只有一个1，这个1表示的是a b从右往左看，

第一个不相同的bit。因此，最后在和diff & a，diff & b, 必然有一个==0， 有一个不==0，这样就可以把a b分开了。

因此，这个是找一个数最低位为 1 的应用。
**/
class Solution {
    public int[] singleNumber(int[] nums) {
        int temp = 0;
        for(int num: nums)
        {
            temp ^= num;
        }
        
        int i = 0;
        while ((temp & 1) == 0)
        {
            temp >>= 1;
            i += 1;
        }
        
        temp = 1 << i;
        int first = 0;
        int second = 0;
        for (int num: nums)
        {
            if ((num & temp) == 0)
            {
                first ^= num;
            }else
            {
                second ^= num;
            }
        }
        
        return new int[]{first, second};
    }
}
