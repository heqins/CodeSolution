package num;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class 连续差相同的数字 {

    /**
     * 返回所有长度为 n 且满足其每两个连续位上的数字之间的差的绝对值为 k 的 非负整数 。
     * 请注意，除了 数字 0 本身之外，答案中的每个数字都 不能 有前导零。例如，01 有一个前导零，所以是无效的；但 0 是有效的。
     * 你可以按 任何顺序 返回答案。
     *
     * 示例 1：
     *
     * 输入：n = 3, k = 7
     * 输出：[181,292,707,818,929]
     * 解释：注意，070 不是一个有效的数字，因为它有前导零。
     * 示例 2：
     *
     * 输入：n = 2, k = 1
     * 输出：[10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]
     * 示例 3：
     *
     * 输入：n = 2, k = 0
     * 输出：[11,22,33,44,55,66,77,88,99]
     * 示例 4：
     *
     * 输入：n = 2, k = 2
     * 输出：[13,20,24,31,35,42,46,53,57,64,68,75,79,86,97]
     *
     *
     * 提示：
     *
     * 2 <= n <= 9
     * 0 <= k <= 9
     */
    private List<Integer> nums = new ArrayList<>();

    public int[] numsSameConsecDiff(int n, int k) {
        for (int i = 1; i <= 9; i++) {
            dfs(i, 1, n, k);
        }

        int[] result = new int[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            result[i] = nums.get(i);
        }

        return result;
    }

    public void dfs(int num, int level, int n, int k) {
        if (level > n) {
            return;
        }

        if (level == n) {
            if (!nums.contains(num)) {
                nums.add(num);
            }

            return;
        }

        char[] chs = String.valueOf(num).toCharArray();
        int last = chs[chs.length - 1] - '0';

        if (last + k <= 9) {
            dfs(num * 10 + (last + k), level + 1, n, k);
        }

        if (last - k >= 0) {
            dfs(num * 10 + (last - k), level + 1, n, k);
        }
    }
}
