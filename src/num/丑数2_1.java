package num;

public class 丑数2_1 {

    public static void main(String[] args) {
        String a = "a";
        String b=  "b";
        String s = a + b;
        System.out.println(s == "ab");
    }

    /**
     * 给你一个整数 n ，请你找出并返回第 n 个 丑数 。
     * 丑数 就是只包含质因数 2、3 和/或 5 的正整数。
     */
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        int index1 = 0;
        int index2 = 0;
        int index3 = 0;

        dp[0] = 1;

        // 三指针+动态规划的思想
        for (int i = 1; i < n; i++) {
            int min = Math.min(dp[index1] * 2, Math.min(dp[index2] * 3, dp[index3] * 5));

            dp[i] = min;

            if (min == dp[index1] * 2) {
                index1++;
            }

            if (min == dp[index2] * 3) {
                index2++;
            }

            if (min == dp[index3] * 5) {
                index3++;
            }
        }

        return dp[n - 1];
    }
}
