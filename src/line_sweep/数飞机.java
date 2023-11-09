package line_sweep;

import java.util.Arrays;
import java.util.List;

public class 数飞机 {

    /**
     * 给出飞机的起飞和降落时间的列表，用序列 interval 表示. 请计算出天上同时最多有多少架飞机？
     *
     * 如果多架飞机降落和起飞在同一时刻，我们认为降落有优先权。
     *
     * 样例
     * 样例 1:
     *
     * 输入: [(1, 10), (2, 3), (5, 8), (4, 7)]
     * 输出: 3
     * 解释:
     * 第一架飞机在1时刻起飞, 10时刻降落.
     * 第二架飞机在2时刻起飞, 3时刻降落.
     * 第三架飞机在5时刻起飞, 8时刻降落.
     * 第四架飞机在4时刻起飞, 7时刻降落.
     * 在5时刻到6时刻之间, 天空中有三架飞机.
     * 样例 2:
     *
     * 输入: [(1, 2), (2, 3), (3, 4)]
     * 输出: 1
     * 解释: 降落优先于起飞.
     * 相关知识
     */

    public class Interval {
        int start, end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    /**
     * 计算空中的飞机个数，可以看成用一个线从左到右扫描的过程，计算每一时刻空中飞机的数量。
     *
     * 优化：只计算所有线段起始位置时天上的飞机即可，因为只有起始点是可能发生变化的点。遇到起点，天上的飞机数+1，遇到终点则-1。
     *
     * 因此，我们先将所有线段的起点、终点排序，并标记是起点还是终点，然后从小到大遍历这些点，
     * 遇到起点则+1，遇到终点-1，返回过程中最大的数值即为空中飞机数的最大值。
     *
     * 需要注意的是：在同一点上会同时有开始点和结尾点，此时应该把结尾点放在前面，否则会出现多计算的情况。
     */
    public class Node implements Comparable<Node> {

        private int val;

        private Boolean isStart;

        public Node(int val, Boolean isStart) {
            this.val = val;
            this.isStart = isStart;
        }

        @Override
        public int compareTo(Node other) {
            if (this.val == other.val) {
                return Boolean.compare(this.isStart, other.isStart);
            }else {
                return Integer.compare(this.val, other.val);
            }
        }
    }

    /**
     * @param airplanes: An interval array
     * @return: Count of airplanes are in the sky.
     */
    public int countOfAirplanes(List<Interval> airplanes) {
        // write your code here
        int size = airplanes.size();
        Node[] array = new Node[size * 2];
        int count = 0;
        int max = 0;

        for (int i = 0; i < airplanes.size(); i++) {
            array[i * 2] = new Node(airplanes.get(i).start, true);
            array[i * 2 + 1] = new Node(airplanes.get(i).end, false);
        }

        Arrays.sort(array);

        for (int i = 0 ; i < array.length; i++) {
            if (array[i].isStart) {
                count++;
                max = Math.max(count, max);
            }else {
                count--;
            }
        }

        return max;
    }
}
