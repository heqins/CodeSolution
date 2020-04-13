/**
Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

Example 1:

Input: 121
Output: true
Example 2:

Input: -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
**/

/**
下面这种解法由热心网友 zeeng 提供，如果是 palindrome，反转后仍是原数字，就不可能溢出，
只要溢出一定不是 palindrome 返回 false 就行。可以参考 Reverse Integer 这题，直接调用 Reverse()。
**/

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        return reverse(x) == x;
    }
    
    private int reverse(int x) {
        int res = 0;
        while (x != 0) {
            if (res > Integer.MAX_VALUE / 10) return -1;
            res = res * 10 + x % 10;
            x = x / 10;
        }
        
        return res;
    }
}
