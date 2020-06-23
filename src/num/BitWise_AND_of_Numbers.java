/**
Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

Example 1:

Input: [5,7]
Output: 4
Example 2:

Input: [0,1]
Output: 0
**/

/**
此题还有另一种解法，不需要用mask，直接平移m和n，每次向右移一位，直到m和n相等，记录下所有平移的次数i，然后再把m左移i位即为最终结果，代码如下：
**/

class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int i = 0;
        while (m != n)
        {
            m >>= 1;
            n >>= 1;
            ++i;
        }
        return (m<<i);
    }
}
