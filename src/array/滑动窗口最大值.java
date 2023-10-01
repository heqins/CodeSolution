package array;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class 滑动窗口最大值 {

    /**
     * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
     * 返回 滑动窗口中的最大值 。
     */
    // 最大堆的思想：时间复杂度O(nlogk) 空间复杂度O(n)
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        // 这里构建一个最大堆，前一个数字的值要大于后一个数字的值
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] pair1, int[] pair2) {
                return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair1[1] - pair2[1];
            }
        });

        // 这里保存每个窗口内的最大值
        int[] res = new int[n - k + 1];

        for (int i = 0; i < k; i++) {
            queue.offer(new int[]{nums[i], i});
        }
        // 初始化第一个窗口的值到目标数组中
        res[0] = queue.peek()[0];

        int result = 0;
        for (int i = k; i < nums.length; i++) {
            queue.offer(new int[]{nums[i], i});

            // 循环判断最大值的下标是否超出了目前窗口的左边界，如果超出了要将这个最大值出堆
            while (queue.peek()[1] <= (i - k)) {
                queue.poll();
            }

            res[i - k + 1] = queue.peek()[0];
        }

        return res;
    }


    /**
     * 为了可以同时弹出队首和队尾的元素，我们需要使用双端队列。满足这种单调性的双端队列一般称作「单调队列」。
     */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        // 队列存下标方便判断当前窗口内最大值是否超过左窗口边界
        LinkedList<Integer> queue = new LinkedList();

        for (int i = 0; i < k; i++) {
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }

            queue.offerLast(i);
        }

        int[] res = new int[n - k + 1];
        res[0] = nums[queue.peekFirst()];

        // O(n)
        for (int i = k; i < n; i++) {
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }

            queue.offerLast(i);

            while (!queue.isEmpty() && queue.peekFirst() <= i - k) {
                queue.pollFirst();
            }


            // res存的是值，队列存的是下标
            res[i - k + 1] = nums[queue.peekFirst()];
        }

        return res;
    }
}
