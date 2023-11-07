package num;

public class 消失的两个数字 {

    /**
     * 给定一个数组，包含从 1 到 N 所有的整数，但其中缺了两个数字。你能在 O(N) 时间内只用 O(1) 的空间找到它们吗？
     *
     * 以任意顺序返回这两个数字均可。
     *
     * 示例 1:
     *
     * 输入: [1]
     * 输出: [2,3]
     * 示例 2:
     *
     * 输入: [2,3]
     * 输出: [1,4]
     * 提示：
     *
     * nums.length <= 30000
     */
    public int[] missingTwo(int[] nums) {
        int n = nums.length + 2, cur = n * (1 + n) / 2;

        for (int x : nums) {
            cur -= x;
        }

        int sum = cur, t = cur / 2;

        cur = t * (1 + t) / 2;

        // [1, t/2]
        // [1, 2, 3, 4, 5, 6, 7, t]
        System.out.println("cur1: " + cur);

        for (int x : nums) {
            if (x <= t) {
                cur -= x;
            }
        }

        System.out.println("cur: " + cur + " sum: " + sum + " t: " + t);
        return new int[]{cur, sum - cur};
    }
}
