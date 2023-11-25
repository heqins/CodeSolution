package str;

public class 最长公共子序列_2 {

    /**
     * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
     *
     * 一个字符串的 子序列 是指这样一个新的字符串：
     * 它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
     * abcde, abrde
     * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
     * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
     */

    // 若text1[i] == text2[j] ，也就是说两个字符串的最后一位相等，那么问题就转化成了
    // 字符串text1的[1,j-1]区间和字符串text2的[1,j-1]区间
    // 的最长公共子序列长度再加上一，即f[i][j] = f[i - 1][j - 1] + 1。（下标从1开始）

    // 若text1[i] != text2[j]，也就是说两个字符串的最后一位不相等，那么字符串text1的[1,i]区间
    // 和字符串text2的[1,j]区间的最长公共子序列长度无法延长，因此f[i][j]就会继承f[i-1][j]与f[i][j-1]中的较大值，
    // 即f[i][j] = max(f[i - 1][j],f[i][j - 1]) 。 （ 下标从1开始）

    public int longestCommonSubsequence(String text1, String text2) {
        // i，j指针 O(mn)
        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }
}
