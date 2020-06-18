/**
Given a string which contains only lowercase letters, remove duplicate letters so that every letter appears once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.

Example 1:

Input: "bcabc"
Output: "abc"

Example 2:

Input: "cbacdcbc"
Output: "acdb"

Note: This question is the same as 1081: https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/

**/

class Solution {
    public String removeDuplicateLetters(String s) {
        StringBuilder sb = new StringBuilder();
        
        int[] count = new int[26];
        boolean[] used = new boolean[26];
        
        char[] chs = s.toCharArray();
        for (char c: chs)
        {
            count[c - 'a']++;
        }
        
        for (char c: chs)
        {
            count[c - 'a']--;
            if (used[c - 'a']) continue;
            
            while (sb.length() > 0 &&
                  sb.charAt(sb.length() - 1) > c &&
                  count[sb.charAt(sb.length() - 1) - 'a'] > 0)
            {
                used[sb.charAt(sb.length() - 1) - 'a'] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
            
            sb.append(c);
            used[c - 'a'] = true;
        }
        
        return sb.toString();
    }
}
