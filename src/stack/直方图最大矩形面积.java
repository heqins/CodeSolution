package stack;

import java.util.PriorityQueue;

public class 直方图最大矩形面积 {

    /**
     * 题目：直方图是由排列在同一基线上的相邻柱子组成的图形。
     * 输入一个由非负数组成的数组，数组中的数字是直方图中柱子的
     * 高。求直方图中最大矩形面积。假设直方图中柱子的宽都为1。例
     * 如，输入数组[3，2，5，4，6，1，4，2]，其对应的直方图如图6.3
     * 所示，该直方图中最大矩形面积为12，如阴影部分所示。
     * @param args
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
        PriorityQueue<直方图最大矩形面积.Node> queue = new PriorityQueue<>((x, y) -> y.val - x.val);
        int[] right = new int[heights.length];
        int[] left = new int[heights.length];

        for (int i = 0; i < heights.length; i++) {
            // 从左往右遍历的时候，此时出栈找到的是以当前node.id高度能拼出的矩阵最右边的那个端点
            while (!queue.isEmpty() && queue.peek().val > heights[i]) {
                直方图最大矩形面积.Node node = queue.poll();
                right[node.id] = i - node.id;
            }

            queue.offer(new 直方图最大矩形面积.Node(heights[i], i));
        }

        while (!queue.isEmpty()) {
            直方图最大矩形面积.Node node = queue.poll();
            right[node.id] = heights.length - node.id;
        }

        for (int i = heights.length - 1; i >= 0; i--) {
            while (!queue.isEmpty() && queue.peek().val > heights[i]) {
                直方图最大矩形面积.Node node = queue.poll();
                left[node.id] = node.id - i;
            }

            queue.offer(new 直方图最大矩形面积.Node(heights[i], i));
        }

        while (!queue.isEmpty()) {
            直方图最大矩形面积.Node node = queue.poll();
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
