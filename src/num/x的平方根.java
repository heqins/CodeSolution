package num;

public class x的平方根 {

    /**
     * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
     *
     * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
     *
     * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
     */

    public static void main(String[] args) {
        mySqrt(8);
    }

    public static int mySqrt(int x) {
        int left = 0;
        int right = x;
        if (x == 0) {
            return 0;
        }

        if (x == 1) {
            return 1;
        }

        int result = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            // 合并等于和小于的情况，因为小于才是向下取整，例如8的算数平方根是2.8...; 3^2>8,而2^2<8
            if ((long) mid * mid <= x) {
                left = mid + 1;

                result = mid;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}
