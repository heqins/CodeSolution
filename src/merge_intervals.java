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
