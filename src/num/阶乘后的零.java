package num;

public class 阶乘后的零 {

    /**
     * https://leetcode.cn/problems/factorial-trailing-zeroes/solutions/47030/xiang-xi-tong-su-de-si-lu-fen-xi-by-windliang-3/
     * 综上，规律就是每隔 5 个数，出现一个 5，每隔 25 个数，出现 2 个 5，
     * 每隔 125 个数，出现 3 个 5... 以此类推。
     *
     * 最终 5 的个数就是 n / 5 + n / 25 + n / 125 ...
     *
     * 写程序的话，如果直接按照上边的式子计算，分母可能会造成溢出。
     * 所以算 n / 25 的时候，我们先把 n 更新，n = n / 5，然后再计算 n / 5 即可
     *
     * 作者：windliang
     * 链接：https://leetcode.cn/problems/factorial-trailing-zeroes/solutions/47030/xiang-xi-tong-su-de-si-lu-fen-xi-by-windliang-3/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            count += n / 5;
            n /= 5;
        }

        return count;
    }
}
