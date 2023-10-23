package num;

public class 两数相除 {
    /**
     * 给你两个整数，被除数 dividend 和除数 divisor。将两数相除，要求 不使用 乘法、除法和取余运算。
     *
     * 整数除法应该向零截断，也就是截去（truncate）其小数部分。例如，8.345 将被截断为 8 ，-2.7335 将被截断至 -2 。
     *
     * 返回被除数 dividend 除以除数 divisor 得到的 商 。
     *
     * 注意：假设我们的环境只能存储 32 位 有符号整数，其数值范围是 [−231,  231 − 1] 。本题中，如果商 严格大于 231 − 1 ，则返回 231 − 1 ；如果商 严格小于 -231 ，则返回 -231 。
     *
     *
     *
     * 示例 1:
     *
     * 输入: dividend = 10, divisor = 3
     * 输出: 3
     * 解释: 10/3 = 3.33333.. ，向零截断后得到 3 。
     * 示例 2:
     *
     * 输入: dividend = 7, divisor = -3
     * 输出: -2
     * 解释: 7/-3 = -2.33333.. ，向零截断后得到 -2 。
     */
    static final int MAX = Integer.MAX_VALUE;
    static final int MIN = Integer.MIN_VALUE;

    public int divide(int dividend, int divisor) {
        // 溢出情况
        if (dividend == MIN && divisor == -1) {
            return MAX;
        }

        // 记录结果的符号
        int sign = -1;
        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) {
            sign = 1;
        }

        // 如果被除数是最小值，那么Math.abs()得不到对应的正数溢出了，所以不如全部用负数表示

        // 全部转换成负数，防止溢出
        dividend = dividend > 0 ? -dividend : dividend;
        divisor = divisor > 0 ? -divisor : divisor;

        int ans = 0;

        // 倍乘法，注意都是负数了，比较的时候与正数相反
        // 简单点理解，就是每次减去除数的 2^x 倍数，剩下的部分继续按这样的规则继续
        while (dividend <= divisor) {
            int tmp = divisor, count = 1;
            // 这里注意不要写成 tmp + tmp >= dividend，这样写加法有可能会溢出导致死循环
            while (tmp >= dividend - tmp) {
                // tmp 和 count 每次增加一倍，所以叫倍增
                tmp += tmp;
                count += count;
            }
            // 被除数减去除数的 2^x 倍数做为新的被除数
            dividend -= tmp;
            // count 即 2^x
            ans += count;
        }

        return sign < 0 ? -ans : ans;
    }
}
