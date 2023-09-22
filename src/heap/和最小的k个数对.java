package heap;

import java.util.*;
import java.util.stream.Collectors;

public class 和最小的k个数对 {

    /**
     * 题目：给定两个递增排序的整数数组，从两个数组中各取一个
     * 数字u和v组成一个数对（u，v），请找出和最小的k个数对。例如，
     * 输入两个数组[1，5，13，21]和[2，4，9，15]，和最小的3个数对
     * 为（1，2）、（1，4）和（2，5）。
     * @param args
     */
    public static void main(String[] args) {

    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        Queue<int[]> maxHeap = new PriorityQueue<>((p1, p2) -> p2[0] + p2[1] - p1[0] - p1[1]);
        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            for (int j = 0; j < Math.min(k, nums2.length); j++) {
                if (maxHeap.size() < k) {
                    maxHeap.offer(new int[]{nums1[i], nums2[j]});
                }else {
                    if ((maxHeap.peek()[0] + maxHeap.peek()[1]) > (nums1[i] + nums2[j])) {
                        maxHeap.poll();
                        maxHeap.offer(new int[]{nums1[i], nums2[j]});
                    }
                }
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        while (!maxHeap.isEmpty()) {
            int[] val = maxHeap.poll();
            result.add(Arrays.asList(val[0], val[1]));
        }

        return result;
    }
}
