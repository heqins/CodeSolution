package str;

public class 不含重复字符的最长子字符串 {

    /**
     * 题目：输入一个字符串，求该字符串中不含重复字符的最长子字符串的长度。
     * 例如，输入字符串"babcca"，其最长的不含重复字符的子字符串是"abc"，长度为3。
     * @param args
     */
    public int lengthOfLongestSubstring(String s) {
        int result = helper(s);

        return result;
    }

    public int helper(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int[] exist = new int[256];
        int length = s.length();

        // 双指针维护一个滑动窗口
        // left的右一个位置到right是有效区间
        int left = -1;
        int result = 0;

        for (int right = 0; right < length; right++) {
            char ch = s.charAt(right);
            exist[ch]++;

            // 不能是if,因为可能重复的不在最左边，需要向右循环
            while (hasGreaterValue(exist)) {
                left++;
                exist[s.charAt(left)]--;
            }

            result = Math.max(result, right - left);
        }

        return result;
    }

    public boolean hasGreaterValue(int[] exist) {
        for (int i = 0; i < exist.length; i++) {
            if (exist[i] > 1) {
                return true;
            }
        }

        return false;
    }
}
