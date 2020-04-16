/**
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

Note: m and n will be at most 100.

Example 1:

Input:
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
Output: 2
Explanation:
There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right
**/

/**
这里就能看出来初始化 d p数组的大小为 (m+1) x (n+1)，是为了 handle 边缘情况，当i或j为0时，减1可能会出错。

当某个位置是障碍物时，其 dp 值为0，直接跳过该位置即可。这里还需要初始化 dp 数组的某个值，使得其能正常累加。

当起点不是障碍物时，其 dp 值应该为1，即dp[1][1] = 1，由于其是由 dp[0][1] + dp[1][0] 更新而来，所以二者中任意一个初始化为1即可。

由于之后 LeetCode 更新了这道题的 test case，使得使用 int 型的 dp 数组会有溢出的错误，所以改为使用 long 型的数组来避免 overflow，代码如下：

**/

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) return 0;
        
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        
        int[][] dp = new int[m + 1][n + 1];
        
        dp[0][1] = 1;
        
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (obstacleGrid[i - 1][j - 1] != 0) continue;
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        
        return dp[m][n];
    }
}
