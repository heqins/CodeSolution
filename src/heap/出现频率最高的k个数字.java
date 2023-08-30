package heap;

import java.util.*;

public class 出现频率最高的k个数字 {

    /**
     * 题目：请找出数组中出现频率最高的k个数字。例如，当k等于2
     * 时，输入数组[1，2，2，1，3，1]，由于数字1出现了3次，数字2出
     * 现了2次，数字3出现了1次，因此出现频率最高的2个数字是1和2。
     * @param args
     */
    public static void main(String[] args) {

    }

    public static List<Integer> find(int k, int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.offer(entry);
            }else {
                if (minHeap.peek().getValue() < entry.getValue()) {
                    minHeap.poll();
                    minHeap.offer(entry);
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry: minHeap) {
            result.add(entry.getValue());
        }

        return result;
    }
}
