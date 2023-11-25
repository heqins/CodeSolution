package num;

public class 整数反转_2 {

    /**
     * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
     *
     * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
     *
     * 假设环境不允许存储 64 位整数（有符号或无符号）。
     *
     * @param args
     */
    public int reverse(int x) {
        int res = 0;
        int temp = 0;

        while (x != 0) {
            temp = x % 10;

            if (res > 214748364 || (res == 214748364 && temp > 7)) return 0;

            if (res < -214748364 || (res == -214748364 && temp < -8)) return 0;

            res = res * 10 + temp;

            x = x / 10;
        }

        return res;
    }
}
