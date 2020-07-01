/**
Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 

Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.


**/

import java.util.HashMap;

public class longest_substring_without_repeating {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> count = new HashMap();
        int j = 0;
        int max = 0;
        for (int i =0; i < s.length(); i++) {
            if (count.containsKey(s.charAt(i))) {
                j = Math.max(j, count.get(s.charAt(i)) + 1);
            }
            count.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        longest_substring_without_repeating ls = new longest_substring_without_repeating();
        System.out.println(ls.lengthOfLongestSubstring("abdscddaaa"));
    }
}
