import java.util.*;

public class topk_frequent_elements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int i: nums) {
            count.put(i, count.getOrDefault(i, 0) + 1);
        }

        // init heap 'the less frequent element first'
        PriorityQueue<Integer> heap =
                new PriorityQueue<Integer>((n1, n2) -> count.get(n1) - count.get(n2));

        for (int n: count.keySet()) {
            heap.add(n);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        // build output list
        List<Integer> top_k = new LinkedList<>();
        while (!heap.isEmpty())
            top_k.add(heap.poll());
        Collections.reverse(top_k);
        return top_k;
    }

    public static void main(String[] args) {
        topk_frequent_elements top = new topk_frequent_elements();
        int[] nums = new int[]{2, 2, 3, 4, 5, 1, -1, -1, -1, 1, 7};
        System.out.println(top.topKFrequent(nums, 2));
    }
}
