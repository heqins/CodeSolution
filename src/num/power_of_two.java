/**
Given an integer, write a function to determine if it is a power of two.

Example 1:

Input: 1
Output: true 
Explanation: 20 = 1
Example 2:

Input: 16
Output: true
Explanation: 24 = 16
Example 3:

Input: 218
Output: false
**/


/**
那么我们很容易看出来2的次方数都只有一个1，剩下的都是0，所以我们的解题思路就有了，我们只要每次判断最低位是否为1，

然后向右移位，最后统计1的个数即可判断是否是2的次方数，代码如下：
**/

class Solution {
    public boolean isPowerOfTwo(int n) {
        int count = 0;
        while (n > 0)
        {
            count += (n & 1);
            n >>= 1;
        }
        
        return count == 1;
    }
}
