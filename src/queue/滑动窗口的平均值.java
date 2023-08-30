package queue;

import java.util.LinkedList;
import java.util.Queue;

public class 滑动窗口的平均值 {

    public static class MovingAverage {
        private int capacity;

        private Queue<Integer> nums;

        private int sum;

        public MovingAverage(int size) {
            this.nums = new LinkedList<>();
            this.capacity = size;
        }

        public Double next(int val) {
            nums.offer(val);
            sum += val;

            if (nums.size() > capacity) {
                sum -= nums.poll();
            }

            return (double) sum / nums.size();
        }
    }

    /**
     * 题目：请实现如下类型MovingAverage，计算滑动窗口中所有数
     * 字的平均值，该类型构造函数的参数确定滑动窗口的大小，每次调
     * 用成员函数next时都会在滑动窗口中添加一个整数，并返回滑动窗
     * 口中所有数字的平均值。
     * @param args
     */
    public static void main(String[] args) {

    }
}
