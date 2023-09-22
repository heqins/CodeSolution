package queue;

import java.util.LinkedList;
import java.util.Queue;

public class 最近请求次数 {

    public static class RecentCounter {
        private Queue<Integer> items;

        private int windowSize;

        public RecentCounter(int windowSize) {
            this.windowSize = windowSize;
            items = new LinkedList<>();
        }

        public int ping(int t) {
            items.offer(t);
            while (items.peek() + windowSize < t) {
                items.poll();
            }

            return items.size();
        }
    }


    /**
     * 题目：请实现如下类型RecentCounter，它是统计过去3000ms内
     * 的请求次数的计数器。该类型的构造函数RecentCounter初始化计数
     * 器，请求数初始化为0；函数ping（int t）在时间t添加一个新请求
     * （t表示以毫秒为单位的时间），并返回过去3000ms内（时间范围为
     * [t-3000，t]）发生的所有请求数。假设每次调用函数ping的参数t
     * 都比之前调用的参数值大。
     * @param args
     */
    public static void main(String[] args) {

    }
}
