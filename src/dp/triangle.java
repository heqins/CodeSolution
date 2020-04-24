/**
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:

Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
**/

/**
动态规划Dynamic Programming还是不二之选啊。其实这道题和 Dungeon Game 非常的类似，都是用DP来求解的问题。

那么其实我们可以不新建dp数组，而是直接复用triangle数组，我们希望一层一层的累加下来，从而使得 triangle[i][j] 是从最顶层到 (i, j) 位置的最小路径和，

那么我们如何得到状态转移方程呢？其实也不难，因为每个结点能往下走的只有跟它相邻的两个数字，

那么每个位置 (i, j) 也就只能从上层跟它相邻的两个位置过来，也就是 (i-1, j-1) 和 (i-1, j) 这两个位置，那么状态转移方程为：
**/

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (j == 0) {
                    triangle.get(i).set(j, triangle.get(i).get(j) + triangle.get(i-1).get(j));
                }else if (j == triangle.get(i).size() - 1) {
                    triangle.get(i).set(j, triangle.get(i).get(j) + triangle.get(i-1).get(j-1));
                }else {
                    triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i-1).get(j-1), triangle.get(i-1).get(j)));
                }
            }
        }
        System.out.println(triangle);
        return Collections.min(triangle.get(triangle.size() - 1));
    }
}
