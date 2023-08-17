package num;

import java.util.Arrays;

public class 前n个数字二进制形式中1的个数 {

    /**
     * 题目：输入一个非负数n，请计算0到n之间每个数字的二进制形式中1的个数，并输出一个数组。
     * 例如，输入的n为4，由于0、1、2、3、4的二进制形式中1的个数分别为0、1、1、2、1，因此输出数组[0，1，1，2，1]。
     */
    public static void main(String[] args) {
        int[] ints = countBits(5);

        System.out.println(Arrays.toString(ints));
        System.out.println(4 & 3);
    }

    /**
     * 利用整数i的二进制形式中1的个数比“i&（i-1）”的二进制形式中1的个数多1
     * 时间复杂度：O(n)
     * @param num
     * @return
     */
    public static int[] countBits(int num) {
        int[] result = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            result[i] = result[i & i - 1] + 1;
        }

        return result;
    }
}
