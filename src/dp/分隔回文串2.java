package dp;

public class 分隔回文串2 {

    /**
     * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。
     * 返回符合要求的 最少分割次数 。
     */
    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n];

        // 初始化dp数组
        for (int i = 0; i < n; i++) {
            // i=0就表示只有1个字符的时候
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
