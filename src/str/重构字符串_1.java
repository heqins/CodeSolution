package str;

import java.util.PriorityQueue;

public class 重构字符串_1 {

    /**
     * 给定一个字符串 s ，检查是否能重新排布其中的字母，使得两相邻的字符不同。
     * 返回 s 的任意可能的重新排列。若不可行，返回空字符串 "" 。
     */
    public String reorganizeString(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> (o2[1] - o1[1]));
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                queue.offer(new int[]{i, count[i]});
            }
        }

        StringBuilder sb = new StringBuilder();
        int[] pre = new int[]{-1, 0};

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            // 当前频率减1后放到下一回合重新加入队列，所以要用pre指针
            if (pre[1] > 0) {
                queue.offer(pre);
            }

            sb.append((char) (cur[0] + 'a'));
            cur[1]--;
            pre = cur;

            // 如果最后队列为空，但当前字符还有值
            if (queue.isEmpty() && pre[1] > 0) {
                return "";
            }
        }

        return sb.toString();
    }
}
