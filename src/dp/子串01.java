package dp;

import java.util.Scanner;

public class 子串01 {

    /**
     * 小美定义一个 01 串的权值为：每次操作选择一位取反，使得相邻字符都不相等的最小操作次数。
     *
     * 例如，"10001"的权值是 1，因为只需要修改一次：对第三个字符取反即可。
     *
     * 现在小美拿到了一个 01 串，她希望你求出所有非空连续子串的权值之和，你能帮帮她吗？
     * @param args
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int n = s.length();
        int[][] f = new int[2001][2];
        long ans = 0;

        // 为了缩小问题规模，考虑第i位和第i-1位的情况：
        //
        //若s[i]==s[i-1]，此时i和i-1这两个之间必须要变一个，可以分为以下两种情况：i不变i-1变；i变i-1不变，状态转移方程如下
        //
        //f[i][0] = f[i-1][1];
        //
        //f[i][1] = f[i-1][0] + 1;
        //
        //若s[i]!=s[i-1]，此时也可以分为两种情况：i和i-1都不变；i和i-1都变，状态转移方程如下
        //
        //f[i][0] = f[i-1][0];
        //
        //f[i][1] = f[i-1][1] + 1;
        //
        //初始状态定义为f[i-1][0] = 0;f[i-1][1] = 1;     // 1表示当前为修改所以初始值为1
        for (int j = 0; j < n; j++) {
            long sum = 0;
            f[j][0] = 0;
            f[j][1] = 1;

            for (int i = j + 1; i < n; i++) {
                if (s.charAt(i) == s.charAt(i - 1)) {
                    f[i][0] = f[i - 1][1];
                    f[i][1] = f[i - 1][0] + 1;
                } else {
                    f[i][0] = f[i - 1][0];
                    f[i][1] = f[i - 1][1] + 1;
                }
                sum += Math.min(f[i][0], f[i][1]);
            }
            ans += sum;
        }

        System.out.println(ans);
    }
}
