package num;

import java.util.Arrays;

public class 只出现一次的数字 {

    /**
     * 题目：输入一个整数数组，数组中只有一个数字出现了一次，
     * 而其他数字都出现了3次。请找出那个只出现一次的数字。
     * 例如，如果输入的数组为[0，1，0，1，0，1，100]，则只出现一次的数字是100。
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 1, 0, 1, 100};
        int[] bitNums = new int[32];
        for (int num: nums) {
            for (int i = 0; i < 32; i++) {
                bitNums[i] += (num >> (31 - i)) & 1;
            }
        }

        System.out.println(Arrays.toString(bitNums));
    }
}
