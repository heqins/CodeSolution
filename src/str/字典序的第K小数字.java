package str;

public class 字典序的第K小数字 {

    /**
     * 给定整数 n 和 k，返回  [1, n] 中字典序第 k 小的数字。
     */
    public int findKthNumber(int n, int k) {
        int curr = 1;
        k--; // 将k减1，因为第一个整数1已经包括在内

        while (k > 0) {
            int count = getCount(n, curr, curr + 1);
            if (count <= k) {
                curr++; // 移动到下一个整数
                k -= count;
            } else {
                curr *= 10; // 移动到下一层的第一个整数
                k--;
            }
        }

        return curr;
    }

    // 辅助函数：计算在n范围内，以prefix为前缀的整数数量
    private int getCount(int n, long prefix, long nextPrefix) {
        int count = 0;
        while (prefix <= n) {
            count += Math.min(n + 1, nextPrefix) - prefix;
            prefix *= 10;
            nextPrefix *= 10;
        }
        return count;
    }

}
