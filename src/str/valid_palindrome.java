/**
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false
**/
/**
统一处理大小写字母的情况，因为小写字母比其对应的大写字母的ASCII码大32，所以如果遇到了大写字母，我们需要先加上32，然后再减去'a'，就知道其相对于'a'的位置了，这个值肯定是小于32的，所以对32取余没啥影响。
如果遇到小写字母，虽然加上了32，但是最后对32取余了，多加的32也就没了，所以还是能得到其相对于'a'的正确位置。
**/

class Solution {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        
        while (left < right) {
            if (!isAlphaNum(s.charAt(left))) {
                left++;
            }else if (!isAlphaNum(s.charAt(right))) {
                right--;
            }else if ((s.charAt(left) + 32 - 'a') % 32 != (s.charAt(right) + 32 - 'a') % 32) {
                System.out.println(left);
                System.out.println(right);
                return false;
            }else {
                left++;
                right--;
            }
        }
        return true;
    }
    
     private boolean isAlphaNum(char ch) {
        if (ch >= 'a' && ch <= 'z') return true;
        if (ch >= 'A' && ch <= 'Z') return true;
        if (ch >= '0' && ch <= '9') return true;
        return false;
    }
}
