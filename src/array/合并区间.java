package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 合并区间 {

    /**
     * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请
     * 你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
     */

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,3}, {2,6}, {8,10}, {15,18}};
        merge(intervals);
    }

    public static int[][] merge(int[][] intervals) {

        // 首先按照左端点排序
        // 如果前一个区间的右端点>=当前区间的左端点，那么应该合并更新，此时新的区间左端点为前一个区间的左端点，
        // 右端点为前一个区间的右端点，当前区间的右端点取最大值

        List<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
        int start = intervals[0][0], end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++){
            // 两个区间有重叠
            if (intervals[i][0] <= end){
                end = Math.max(end, intervals[i][1]);
            }else{
                // 两个区间没有重叠，保存[start,end]，然后更新
                ans.add(new int[] {start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        ans.add(new int[] {start, end});
        int[][] res = new int[ans.size()][2];
        for (int i = 0; i < res.length; i++){
            res[i] = ans.get(i);
        }
        return res;
    }
}
