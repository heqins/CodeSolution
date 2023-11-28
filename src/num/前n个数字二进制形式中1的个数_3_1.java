package num;

import java.util.Arrays;

public class 前n个数字二进制形式中1的个数_3_1 {

    /**
     * 题目：输入一个非负数n，请计算0到n之间每个数字的二进制形式中1的个数，并输出一个数组。
     * 例如，输入的n为4，由于0、1、2、3、4的二进制形式中1的个数分别为0、1、1、2、1，因此输出数组[0，1，1，2，1]。
     * 2 - 010 3 - 011 -> 000
     */
    public static void main(String[] args) {
        int[] ints = countBits(5);
        // 001 010 011 100 101 110 111
        // 1 2 3 4 5 6 7
        System.out.println(Arrays.toString(ints));
        System.out.println(4 & 3);
    }

    /**
     * 利用整数i的二进制形式中1的个数比“i&（i-1）”的二进制形式中1的个数多1
     * 时间复杂度：O(n)
     * @return
     */
    public static int[] countBits(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++){
            // 奇数时，二进制表示中，奇数一定比前面那个偶数多一个 1
            if (i % 2 == 1){
                dp[i] = dp[i - 1] + 1;
            }
            // 偶数时，它的二进制1的位数与i/2 的二进制1的位数相等；
            // 偶数的二进制末尾是 0，右移一位等于i/2，且1的个数不会变，故使用位运算i>>1当作i/2
            else{
                dp[i] = dp[i >> 1];
            }
        }

        return dp;
    }
}
