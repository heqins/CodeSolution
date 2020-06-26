/**
Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

Note:

    s could be empty and contains only lowercase letters a-z.
    p could be empty and contains only lowercase letters a-z, and characters like . or *.

Example 1:

Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".

Example 2:

Input:
s = "aa"
p = "a*"
Output: true
Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".

Example 3:

Input:
s = "ab"
p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".

Example 4:

Input:
s = "aab"
p = "c*a*b"
Output: true
Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".

Example 5:

Input:
s = "mississippi"
p = "mis*is*p*."
Output: false


**/


/**
用递归的思想解决，对于一次判断有以下情况：

    当模式中的第二个字符不是“*”时：
        如果字符串第一个字符和模式中的第一个字符相匹配，那么字符串和模式都后移一个字符，然后匹配剩余的。
        如果字符串第一个字符和模式中的第一个字符相不匹配，直接返回false。

    当模式中的第二个字符是“*”时：
        如果字符串第一个字符跟模式第一个字符不匹配，则模式后移2个字符，继续匹配。
        如果字符串第一个字符跟模式第一个字符匹配，可以有3种匹配方式：
            模式后移2字符，相当于x*被忽略；
            字符串后移1字符，模式后移2字符；
            字符串后移1字符，模式不变，即继续匹配字符下一位，因为*可以匹配多位；

**/


class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        
        return matchCore(s, p, 0, 0);
    }
    
    public boolean matchCore(String s, String p, int i, int j)
    {
        if (i == s.length() && j == p.length()) return true;
        
        if (i < s.length() && j == p.length()) return false;
        
        if ((j + 1) < p.length() && p.charAt(j + 1) == '*')
        {
            if (i != s.length() && p.charAt(j) == s.charAt(i) || (p.charAt(j) == '.' && i != s.length()))
            {
                return matchCore(s, p, i + 1, j + 2)
                    || matchCore(s, p, i + 1, j)
                    || matchCore(s, p, i, j + 2);
            }else
            {
                return matchCore(s, p, i, j + 2);
            }
        }
        
        if ((i != s.length() && s.charAt(i) == p.charAt(j)) || (p.charAt(j) == '.' && i != s.length()))
        {
            return matchCore(s, p, i + 1, j + 1);
        }
        
        return false;
    }
}
