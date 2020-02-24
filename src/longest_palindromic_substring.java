// 最大回文子字符串 https://www.bilibili.com/video/av78107789?from=search&seid=9372089928080728246
public class longest_palindromic_substring {
    private int index;
    private int maxLen;
    public String longestPalindrome(String s) {
        if (s.length() < 2) return s;

        for (int i = 0; i < s.length(); i++) {
            // 每一个当作中心
            helper(s, i, i); // palindrome odd, 以当前字符串为中心是否存在回文
            helper(s, i, i + 1); 
        }

        return s.substring(index, index + maxLen);
    }

    private void helper(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }

        if (maxLen < k - j - 1) {
            index = j + 1;
            maxLen = k - j - 1;
        }
    }
}
