package num;

public class 数字范围按位与_3 {

    /**
     * 给你两个整数 left 和 right ，表示区间 [left, right] ，
     * 返回此区间内所有数字 按位与 的结果（包含 left 、right 端点）。
     *
     *
     * 示例 1：
     * 101, 111, 110
     * 输入：left = 5, right = 7
     * 输出：4
     * 示例 2：
     *
     * 输入：left = 0, right = 0
     * 输出：0
     * 示例 3：
     *
     * 输入：left = 1, right = 2147483647
     * 输出：0
     *
     *
     * 提示：
     *
     * 0 <= left <= right <= 231 - 1
     * @param m
     * @param n
     * @return
     */
    public static int rangeBitwiseAnd(int m, int n) {
        // 直接遍历m...n，挨个按位与，必定不符合算法时间复杂度要求。
        //
        //  分析按位与的特点，考察所有参与运算的数，按照二进制形式的最低位对齐。
        //  结果数中的某一位，取决于所有运算数中此对应位，只要有一个为0，结果为0，否则为1。
        //
        //  考察计算端点值，m和n，将m和n都表示为二进制形式（高位补0，补足32位），
        //  其二进制形式的最大公共前缀表示为X，则可以表示为
        //  `m=X0******`(不妨假设后面还剩了6位）
        //  `n=X1******`
        //  那么，`(m,n]`之间必然有一个数是
        //  `t=X1000000(m<t<=n)`
        //  因此，`m~n`全部按位与的结果就是`r=X0000000`。（即m和n二进制形式的最长公共前缀）
        //
        //作者：liberg
        //链接：https://leetcode.cn/problems/bitwise-and-of-numbers-range/solutions/391916/da-bai-hua-ju-li-jie-shi-yong-shi-ji-bai-9996-by-l/
        //来源：力扣（LeetCode）
        //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

        int shift = 0;

        while(m < n) {
            //一开始，m<n，一直往右移直到m=n，求得m和n二进制形式下的最长公共前缀
            m >>= 1;
            n >>= 1;
            shift++;
        }

        return m << shift;
    }

    public static void main(String[] args) {
        rangeBitwiseAnd(5, 7);
    }
}
