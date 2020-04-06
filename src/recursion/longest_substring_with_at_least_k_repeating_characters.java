/**
Find the length of the longest substring T of a given string (consists of lowercase letters only) such that every character in T appears no less than k times.

Example 1:

Input:
s = "aaabb", k = 3

Output:
3

The longest substring is "aaa", as 'a' is repeated 3 times.
Example 2:

Input:
s = "ababbc", k = 2

Output:
5

The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
**/

public class longest_substring_with_at_least_k_repeating_characters {
    /**
     * The first part of the program determines whether the given string is a "valid " string or not,
     * being a valid string means all the characters in the string appears more than k times.
     * Of course, not all strings given will be valid strings, therefore, the program use
     * characters appeared less than k times as "splits", to divide the string into substrings,
     * and then recursively calls itself onto each substring to determine whether the substring
     * is valid or not. since there might be multiple valid substrings in a string, we store the
     * length of the substring in variable "result" and only returns the longest substring length
     * using Math.max() function.
     
     下面这种解法用的分治法 Divide and Conquer 的思想，看起来简洁了不少，但是个人感觉比较难想，
     这里使用了一个变量 max_idx，是用来分割子串的，实现开始统计好了字符串s的每个字母出现的次数，
     然后再次遍历每个字母，若当前字母的出现次数小于k了，则从开头到前一个字母的范围内的子串可能是满足题意的
     ，还需要对前面的子串进一步调用递归，用返回值来更新当前结果 res，此时变量 ok 标记为 false，
     表示当前整个字符串s是不符合题意的，因为有字母出现次数小于k，此时 max_idx 更新为 i+1，
     表示再从新的位置开始找下一个出现次数小于k的字母的位置，可以对新的范围的子串继续调用递归。
     当 for 循环结束后，若 ok 是 true，说明整个s串都是符合题意的，直接返回n，否则要对 [max_idx, n-1] 范围内的子串再次调用递归，
     因为这个区间的子串也可能是符合题意的，还是用返回值跟结果 res 比较，谁大就返回谁，参见代码如下：

     * @param s
     * @param k
     * @return
     */

    public int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0) return 0;
        char[] chars = new char[26];
        // record the frequency of each character
        for (int i = 0; i < s.length(); i += 1) chars[s.charAt(i) - 'a'] += 1;
        boolean flag = true;
        for (int i = 0; i < chars.length; i += 1) {
            if (chars[i] < k && chars[i] > 0) flag = false;
        }
        // return the length of string if this string is a valid string
        if (flag == true) return s.length();
        int result = 0;
        int start = 0, cur = 0;
        // otherwise we use all the infrequent elements as splits
        while (cur < s.length()) {
            if (chars[s.charAt(cur) - 'a'] < k) {
                result = Math.max(result, longestSubstring(s.substring(start, cur), k));
                start = cur + 1;
            }
            cur++;
        }
        result = Math.max(result, longestSubstring(s.substring(start), k));
        return result;
    }

    public static void main(String[] args) {
        String s = "abcccccabcbc";
        int num = 4;
        System.out.println(new longest_substring_with_at_least_k_repeating_characters().longestSubstring(s, num));
    }
}
