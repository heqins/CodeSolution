package str;

public class 验证回文串2 {

    /**
     * 给你一个字符串 s，最多 可以从中删除一个字符。
     *
     * 请你判断 s 是否能成为回文字符串：如果能，返回 true ；否则，返回 false 。
     */
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            // 如果当前区间不能构成回文字符串还不能停止，还要继续删除一个字符后判断，删除左指针或右指针的字符
            if (s.charAt(left) != s.charAt(right)) {
                return isValid(s, left + 1, right) || isValid(s, left, right - 1);
            }

            left++;
            right--;
        }

        return true;
    }

    public boolean isValid(String s, int l, int r) {
        int i = l, j = r;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}
