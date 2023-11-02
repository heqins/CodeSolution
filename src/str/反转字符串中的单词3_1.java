package str;

public class 反转字符串中的单词3_1 {

    /**
     * 给定一个字符串 s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
     *
     *
     *
     * 示例 1：
     *
     * 输入：s = "Let's take LeetCode contest"
     * 输出："s'teL ekat edoCteeL tsetnoc"
     * 示例 2:
     *
     * 输入： s = "God Ding"
     * 输出："doG gniD"
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] split = s.split(" ");
        for (int i = 0; i < split.length; i++) {
            char[] cs = split[i].toCharArray();
            for (int j = cs.length - 1; j >= 0; j--) {
                sb.append(cs[j]);
            }

            if (i != split.length - 1) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }
}
