package str;

import java.util.PriorityQueue;

public class 重构字符串 {
    /**
     * 给定一个字符串 s ，检查是否能重新排布其中的字母，使得两相邻的字符不同。
     *
     * 返回 s 的任意可能的重新排列。若不可行，返回空字符串 "" 。
     */
    public String reorganizeString(String s) {
        int[] count = new int[26];
        // 映射字符频率到一个int[26]的数组中
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        // 维护一个堆，按高到低排列
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> (o2[1] - o1[1]));
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                queue.offer(new int[]{i, count[i]});
            }
        }

        StringBuilder sb = new StringBuilder();
        int[] pre = new int[]{-1, 0};

        // 优先按照字符频率高的插入，间隔
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (pre[1] > 0) {
                queue.offer(pre);
            }

            sb.append((char) (cur[0] + 'a'));
            cur[1]--;
            pre = cur;

            if (queue.isEmpty() && pre[1] > 0) {
                return "";
            }
        }

        return sb.toString();
    }
}
