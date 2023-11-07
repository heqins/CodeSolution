package stack;

import java.util.PriorityQueue;

public class 柱状图中最大的矩形 {

    /**
     * 给定非负整数数组 heights ，数组中的数字用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
     *
     * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
     */
    class Node {
        int val;
        int id;

        public Node(int val, int id) {
            this.val = val;
            this.id = id;
        }
    }

    // 扫描线法
    public int largestRectangleArea(int[] heights) {
        PriorityQueue<Node> queue = new PriorityQueue<>((x, y) -> y.val - x.val);
        int[] right = new int[heights.length];
        int[] left = new int[heights.length];

        for (int i = 0; i < heights.length; i++) {
            // 从左往右遍历的时候，此时出栈找到的是以当前node.id高度能拼出的最大矩阵最右边的那个端点
            while (!queue.isEmpty() && queue.peek().val > heights[i]) {
                Node node = queue.poll();
                right[node.id] = i - node.id;
            }

            queue.offer(new Node(heights[i], i));
        }

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            right[node.id] = heights.length - node.id;
        }

        for (int i = heights.length - 1; i >= 0; i--) {
            while (!queue.isEmpty() && queue.peek().val > heights[i]) {
                Node node = queue.poll();
                left[node.id] = node.id - i;
            }

            queue.offer(new Node(heights[i], i));
        }

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            left[node.id] = node.id + 1;
        }

        int result = 0;

        for (int i = 0; i < heights.length; i++) {
            int len = right[i] + left[i] - 1;
            result = Math.max(result, len * heights[i]);
        }

        return result;
    }
}
