package Str;

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
