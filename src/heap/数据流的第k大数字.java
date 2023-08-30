package heap;

import java.util.PriorityQueue;

public class 数据流的第k大数字 {

    public static class KthLargest {
        private int k;

        private PriorityQueue<Integer> heap;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            heap = new PriorityQueue<>(k);

            for (int num : nums) {
                add(num);
            }
        }

        public int add(int num) {
            if (heap.size() < k) {
                heap.offer(num);
            } else if (num > heap.peek()) {
                heap.poll();
                heap.offer(num);
            }

            return heap.peek();
        }
    }

    /**
     * 题目：请设计一个类型KthLargest，它每次从一个数据流中读
     * 取一个数字，并得出数据流已经读取的数字中第k（k≥1）大的数
     * 字。该类型的构造函数有两个参数：一个是整数k，另一个是包含数
     * 据流中最开始数字的整数数组nums（假设数组nums的长度大于k）。
     * 该类型还有一个函数add，用来添加数据流中的新数字并返回数据流
     * 中已经读取的数字的第k大数字。
     * @param args
     */
    public static void main(String[] args) {

    }
}
