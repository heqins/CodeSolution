package str;

public class 编辑距离 {

    /**
     * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
     *
     * 你可以对一个单词进行如下三种操作：
     *
     * 插入一个字符
     * 删除一个字符
     * 替换一个字符
     */
    public int minDistance(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();
        if (m == 0 && n == 0) {
            return 0;
        }

        if (m == 0 && n != 0) {
            return n;
        }

        if (m != 0 && n == 0) {
            return m;
        }

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i <= n; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // skip跳过，继承之前的次数
                    //  注意：由于要考虑空字符串，针对 word1 和 word2 的讨论需要将下标减 1，这一点可以通过如下描述或者参考代码进行理解。
                    dp[i][j] = dp[i - 1][j - 1];
                    continue;
                }
                // [i - 1, j] 删除操作，代表第i个位置删去后，i-1和j个相等
                dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;
            }
        }

        return dp[m][n];
    }
}
