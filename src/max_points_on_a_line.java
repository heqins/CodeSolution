/**
Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.

Example 1:

Input: [[1,1],[2,2],[3,3]]
Output: 3
Explanation:
^
|
|        o
|     o
|  o  
+------------->
0  1  2  3  4
Example 2:

Input: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
Output: 4
Explanation:
^
|
|  o
|     o        o
|        o
|  o        o
+------------------->
0  1  2  3  4  5  6
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
**/

class Solution {
    public int maxPoints(int[][] points) {
        if (points.length < 2) return points.length;
        int max = 1;
        Set<String> set = new HashSet<>();
        // 用Set剪枝
        for (int i = 0; i < points.length && !set.contains(points[i][0] + "-" + points[i][1]); i++) {
            int[] a = points[i];
            Map<Double, Integer> map = new HashMap<>();
            int same = 0;
            int localMax = 1;
            
            for (int j = i + 1; j < points.length; j++) {
                if (isSame(a, points[j])) {
                    same++;
                    continue;
                }
                
                double slope = getSlope(a, points[j]);
                // 更新斜率对应的频率
                map.put(slope, map.getOrDefault(slope, 1) + 1);
                localMax = Math.max(localMax, map.get(slope));
            }
            set.add(points[i][0] + "-" + points[i][1]);
            max = Math.max(max, localMax + same);
        }
        return max;
    }
    
    private boolean isSame(int[] a, int[] b) {
        return a[0] == b[0] && a[1] == b[1];
    }
    
    private double getSlope(int[] a, int[] b) {
        if (a[0] == b[0]) return Double.MAX_VALUE;
        
        if (a[1] == b[1]) return 0;
        
        return ((double)(b[0] - a[0]) / (double)(b[1] - a[1]));
    }
}
