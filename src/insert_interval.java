/**
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
**/

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
int index = 0;
// Add all non-overlapping intervals before the 'newSpan'
while (index < intervals.length && intervals[index][1] < newInterval[0]) {
	result.add(intervals[index++]);
}
// Merge all overlapping intervals into the newSpan
while (index < intervals.length && intervals[index][0] <= newInterval[1]) {
	int[] thisSpan = intervals[index++];
	newInterval[0] = Math.min(thisSpan[0], newInterval[0]);
	newInterval[1] = Math.max(thisSpan[1], newInterval[1]);

}
result.add(newInterval);  // return the merged newspan

// Add all remaining non-overlapping intervals after the merged newSpan
while (index < intervals.length) {
	result.add(intervals[index++]);
}

return result.toArray(new int[result.size()][]);
    }
}
