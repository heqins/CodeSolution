package dp;

public class 解密数字 {
    /**
     * 现有一串神秘的密文 ciphertext，经调查，密文的特点和规则如下：
     *
     * 密文由非负整数组成
     * 数字 0-25 分别对应字母 a-z
     * 请根据上述规则将密文 ciphertext 解密为字母，并返回共有多少种解密结果。
     */
    public int crackNumber(int ciphertext) {
        char[] chs = String.valueOf(ciphertext).toCharArray();
        int len = chs.length;

        if (len == 0) {
            return 0;
        }

        int[] dp = new int[len];
        dp[0] = 1;

        for (int i = 1; i < len; i++) {
            // 每次比较当前位和当前位加上前一位的值
            // 看是否能组成一位或两位
            int a = (chs[i - 1] - '0') * 10 + (chs[i] - '0');
            int b = chs[i] - '0';

            if (b >= 0 && b <= 9) {
                dp[i] = dp[i - 1];
            }

            if (a >= 10 && a <= 25) {
                // 当i=1的时候dp[i]在解码成1位的基础上加上解码成两位这个个数，其他情况下要累加前两位的解码方式
                if (i > 1) {
                    dp[i] += dp[i - 2];
                }else {
                    dp[i]++;
                }
            }
        }

        return dp[len - 1];
    }
}
