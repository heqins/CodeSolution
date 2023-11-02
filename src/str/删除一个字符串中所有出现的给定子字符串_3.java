package str;

public class 删除一个字符串中所有出现的给定子字符串_3 {

    /**
     * 给你两个字符串 s 和 part ，请你对 s 反复执行以下操作直到 所有 子字符串 part 都被删除：
     *
     * 找到 s 中 最左边 的子字符串 part ，并将它从 s 中删除。
     * 请你返回从 s 中删除所有 part 子字符串以后得到的剩余字符串。
     *
     * 一个 子字符串 是一个字符串中连续的字符序列。
     *
     *
     *
     * 示例 1：
     *
     * 输入：s = "daabcbaabcbc", part = "abc"
     * 输出："dab"
     * 解释：以下操作按顺序执行：
     * - s = "daabcbaabcbc" ，删除下标从 2 开始的 "abc" ，得到 s = "dabaabcbc" 。
     * - s = "dabaabcbc" ，删除下标从 4 开始的 "abc" ，得到 s = "dababc" 。
     * - s = "dababc" ，删除下标从 3 开始的 "abc" ，得到 s = "dab" 。
     * 此时 s 中不再含有子字符串 "abc" 。
     * @param s
     * @param part
     * @return
     */
    public String removeOccurrences(String s, String part) {
        if (s.length() == 0 || part.length() == 0) {
            return s;
        }

        int len = part.length();
        for (int i = 0; i <= s.length() - len; i++) {
            if (s.charAt(i) == part.charAt(0)) {
                String temp = s.substring(i, i + len);
                if (temp.equals(part)) {
                    String s2 = s.substring(0, i) + s.substring(i + len);

                    return removeOccurrences(s2, part);
                }
            }
        }

        return s;
    }

}
