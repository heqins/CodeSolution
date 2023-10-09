package str;

public class 反转字符串中的单词 {

    /**
     * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
     * 单词 是由非空格字符组成的字符串。s中使用至少一个空格将字符串中的单词分隔开。
     * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
     * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
     */
    public String reverseWords(String s) {
        // 对于字符串截取的问题可以考虑双指针
        StringBuilder sb = new StringBuilder();
        s = s.trim();
        int i = s.length() - 1, j = i;

        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }

            sb.append(s.substring(i + 1, j + 1));
            if (i >= 0) {
                sb.append(" ");
            }

            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }

            j = i;
        }

        return sb.toString().trim();
    }
}
