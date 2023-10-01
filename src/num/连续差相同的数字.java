package num;

import java.util.PriorityQueue;

public class 连续差相同的数字 {

    /**
     * 返回所有长度为 n 且满足其每两个连续位上的数字之间的差的绝对值为 k 的 非负整数 。
     *
     * 请注意，除了 数字 0 本身之外，答案中的每个数字都 不能 有前导零。例如，01 有一个前导零，所以是无效的；但 0 是有效的。
     *
     * 你可以按 任何顺序 返回答案。
     */

    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> q = new PriorityQueue<>((x, y)->y[1]-x[1]);
        if (a > 0) q.add(new int[]{0, a});
        if (b > 0) q.add(new int[]{1, b});
        if (c > 0) q.add(new int[]{2, c});
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int n = sb.length();
            if (n >= 2 && sb.charAt(n - 1) - 'a' == cur[0] && sb.charAt(n - 2) - 'a' == cur[0]) {
                if (q.isEmpty()) break;
                int[] next = q.poll();
                sb.append((char)(next[0] + 'a'));
                if (--next[1] != 0) q.add(next);
                q.add(cur);
            } else {
                sb.append((char)(cur[0] + 'a'));
                if (--cur[1] != 0) q.add(cur);
            }
        }
        return sb.toString();
    }
}
