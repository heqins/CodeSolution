package str;

public class 最小覆盖子串 {

    /**
     * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
     * 注意：
     *
     * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
     * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
     */

    // 双指针+双哈希表
    public String minWindow(String s, String t) {
        int[] tCharCount = new int[128];
        int[] windowCharCount = new int[128];

        // 统计字符串 t 中各字符的出现次数
        for (char c : t.toCharArray()) {
            tCharCount[c]++;
        }

        int left = 0; // 左指针
        int right = 0; // 右指针
        int required = t.length(); // 字符串 t 中需要的字符数量
        int minLength = Integer.MAX_VALUE; // 最小子串的长度
        int minLeft = 0; // 最小子串的起始位置

        while (right < s.length()) {
            char c = s.charAt(right);
            windowCharCount[c]++;

            // 如果窗口中包含了 t 中的某字符，则将 required 减一
            if (windowCharCount[c] <= tCharCount[c]) {
                required--;
            }

            // 如果窗口中包含了所有 t 中的字符
            while (required == 0) {
                // 更新最小子串的信息
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    minLeft = left;
                }

                char leftChar = s.charAt(left);
                windowCharCount[leftChar]--;

                // 如果窗口中移除了 t 中的某字符，则将 required 增加一
                if (windowCharCount[leftChar] < tCharCount[leftChar]) {
                    required++;
                }

                left++; // 移动左指针缩小窗口
            }

            right++; // 移动右指针扩大窗口
        }

        return (minLength == Integer.MAX_VALUE) ? "" : s.substring(minLeft, minLeft + minLength);
    }

}
