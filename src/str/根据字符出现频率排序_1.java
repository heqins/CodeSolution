package str;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class 根据字符出现频率排序_1 {

    /**
     * 给定一个字符串 s ，根据字符出现的 频率 对其进行 降序排序 。一个字符出现的 频率 是它出现在字符串中的次数。
     *
     * 返回 已排序的字符串 。如果有多个答案，返回其中任何一个。
     */
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap();
        PriorityQueue<int[]> queue = new PriorityQueue(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });

        for (char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry: map.entrySet()) {
            queue.add(new int[]{entry.getKey() - 'a', entry.getValue()});
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();

            for (int i = 0; i < temp[1]; i++) {
                sb.append((char) (temp[0] + 'a'));
            }
        }

        return sb.toString();
    }
}
