package str;

public class 字母移位 {

    /**
     * 有一个由小写字母组成的字符串 s，和一个长度相同的整数数组 shifts。
     *
     * 我们将字母表中的下一个字母称为原字母的 移位 shift() （由于字母表是环绕的， 'z' 将会变成 'a'）。
     *
     * 例如，shift('a') = 'b', shift('t') = 'u', 以及 shift('z') = 'a'。
     * 对于每个 shifts[i] = x ， 我们会将 s 中的前 i + 1 个字母移位 x 次。
     *
     * 返回 将所有这些移位都应用到 s 后最终得到的字符串 。
     */
    public String shiftingLetters(String s, int[] shifts) {
        char[] chs = new char[s.length()];

        for (int i = s.length() - 2; i >= 0; i--) {
            // 注意取模
            shifts[i] = (shifts[i] + shifts[i + 1] % 26);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append((char) ((s.charAt(i) - 'a' + shifts[i]) % 26 + 97));
        }

        return sb.toString();
    }
}
