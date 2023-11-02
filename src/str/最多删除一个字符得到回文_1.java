package str;

public class 最多删除一个字符得到回文_1 {

    /**
     * 题目：给定一个字符串，请判断如果最多从字符串中删除一个
     * 字符能不能得到一个回文字符串。例如，如果输入字符串"abca"，
     * 由于删除字符'b'或'c'就能得到一个回文字符串，因此输出为
     * true。
     * @param args
     */
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                // 尝试删除左边或右边的字符，然后检查剩余的字符串是否是回文
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
            left++;
            right--;
        }

        return true; // 整个字符串都是回文
    }

    // 辅助函数：检查字符串s的子串从start到end是否是回文字符串
    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

}
