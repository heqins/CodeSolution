/**
Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
**/

/**
这道和之前那道 Insert Interval 很类似，这次题目要求我们合并区间，之前那题明确了输入区间集是有序的，而这题没有，

所以我们首先要做的就是给区间集排序，由于我们要排序的是个结构体，所以我们要定义自己的 comparator，才能用 sort 来排序，

我们以 start 的值从小到大来排序，排完序我们就可以开始合并了，首先把第一个区间存入结果中，然后从第二个开始遍历区间集，

如果结果中最后一个区间和遍历的当前区间无重叠，直接将当前区间存入结果中，如果有重叠，

将结果中最后一个区间的 end 值更新为结果中最后一个区间的 end 和当前 end 值之中的较大值，然后继续遍历区间集，以此类推可以得到最终结果，代码如下：

**/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class merge_intervals {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if (n == 0) {
            return new int[0][];
        }
        // Sort
        Arrays.sort(intervals, (o1, o2) -> (o1[0] - o2[0])); // by starting time
        // Init
        List<int[]> result = new ArrayList<>();
        int[] prev = intervals[0]; // requires 0-size check
        result.add(prev);
        // Go through each interval (skip the first interval)
        for (int i = 1; i < n; ++i) {
            int[] curr = intervals[i];
            if (prev[1] >= curr[0] && prev[1] <= curr[1]) {
                // partially overlapped
                prev[1] = curr[1]; // just modify existing prev -> combine
            } else if (prev[1] >= curr[1]) {
                // prev contains curr (inclusive) -> ignore curr
                continue;
            } else { // do not overlapped
                int[] newInterval = new int[] { curr[0], curr[1] };
                result.add(newInterval);
                prev = newInterval;
            }
        }
        // Convert to int[][]
        int[][] ret = new int[result.size()][];
        for (int i = 0; i < result.size(); ++i) {
            ret[i] = result.get(i);
        }
        return ret;
    }
}
