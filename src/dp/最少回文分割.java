package dp;

public class 最少回文分割 {

    // 分隔回文串2

    /**
     * 题目：输入一个字符串，请问至少需要分割几次才可以使分割
     * 出的每个子字符串都是回文？例如，输入字符串"aaba"，至少需要
     * 分割1次，从两个相邻字符'a'中间切一刀将字符串分割成两个回文
     * 子字符串"a"和"aba"。
     */

    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n];

        // 初始化dp数组
        for (int i = 0; i < n; i++) {
            dp[i] = i; // 最坏情况下，每个字符都需要分割一次
        }

        for (int center = 0; center < n; center++) {
            // 以当前字符为中心，向左右扩展，检查回文子串
            int left = center;
            int right = center;

            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                // 如果发现回文子串，更新dp数组
                if (left == 0) {
                    dp[right] = 0;
                } else {
                    dp[right] = Math.min(dp[right], dp[left - 1] + 1);
                }
                left--;
                right++;
            }
            // abbbedf
            // 再次以当前字符和下一个字符之间的空隙为中心，检查回文子串
            left = center;
            right = center + 1;
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                // 如果发现回文子串，更新dp数组
                if (left == 0) {
                    dp[right] = 0;
                } else {
                    dp[right] = Math.min(dp[right], dp[left - 1] + 1);
                }
                left--;
                right++;
            }
        }

        return dp[n - 1];
    }

}
