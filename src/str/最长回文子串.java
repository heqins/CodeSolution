package str;

public class 最长回文子串 {

    /**
     * 给你一个字符串 s，找到 s 中最长的回文子串。
     *
     * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
     */
    private int result = 0;
    private int r = -1;
    private int l = -1;

    public String longestPalindrome(String s) {
        // 遍历，双指针
        for (int i = 0; i < s.length(); i++) {
            helper(s, i, i);
            helper(s, i, i + 1);
        }

        if (r != -1) {
            return s.substring(l + 1, r);
        }

        return "";
    }

    public void helper(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        if (result < (right - left + 1)) {
            result = right - left + 1;
            l = left;
            r = right;
        }
    }
}
