package str;

import java.util.Arrays;

public class 字符串的排列 {

    /**
     * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
     *
     * 换句话说，s1 的排列之一是 s2 的 子串 。
     */
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        if (m > n) {
            return false;
        }

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        // 滑动窗口：两个窗口内字符计数相等则满足
        for (int i = 0; i < m; i++) {
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(count1, count2)) {
            return true;
        }

        for (int i = m; i < n; i++) {
            count2[s2.charAt(i) - 'a']++;
            count2[s2.charAt(i - m) - 'a']--;

            if (Arrays.equals(count1, count2)) {
                return true;
            }
        }

        return false;
    }
}
