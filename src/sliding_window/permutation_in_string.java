/**
Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.

 

Example 1:

Input: s1 = "ab" s2 = "eidbaooo"
Output: True
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input:s1= "ab" s2 = "eidboaoo"
Output: False
 

Note:

The input strings only contain lower case letters.
The length of both given strings is in range [1, 10,000].
**/

/**
Here is a sliding window solution:

Count occurences of all characterers of s1. You can imagine every unique character count as a little stack, and you have 26 stacks, some of them empty. These are the characters and counts you need to match in s2 substrings.

Go through the s2 substrings using a sliding window of size len(s1), modifying your counts on every step based on what character you remove from the left and what character you add from the right. Notice counts may go negative if you add unnecessary characters.

If at any point in time your counts are all zero (stacks are empty), then you have found a solution, return true

If you reached the end of s2, there is no solution, so return false.
**/

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false; //s2 is a shortie
        int[] counts = new int[26];
        
        int needed = 0;
        for (int i = 0; i < s1.length(); i++) {
            int index = s1.charAt(i) - 'a';
            if (counts[index] == 0) needed++; // count number of unique characters that are present
            counts[s1.charAt(i) - 'a']++;                       
        }
        
        for (int i = 0; i < s2.length(); i++) {
            if (i >= s1.length()) { // we can start removing from the left side
                int left = s2.charAt(i-s1.length()) - 'a';
                if (counts[left] == 0) needed++; // moving away from solution
                counts[left]++;
                if (counts[left] == 0) needed--; // moving towards solution
            }   
            int right = s2.charAt(i) - 'a';
            if (counts[right] == 0) needed++; // moving away from solution
            counts[right]--;
            if (counts[right] == 0) needed--; // moving towards solution 
        
            if (needed == 0) return true;
        }   
        return false;
    }
}
