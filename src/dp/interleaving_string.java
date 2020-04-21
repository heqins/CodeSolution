/**
Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

Example 1:

Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
Output: true
Example 2:

Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
Output: false
**/

/**
这道求交织相错的字符串和之前那道 Word Break 的题很类似，就像我之前说的只要是遇到字符串的子序列或是匹配问题直接就上动态规划 Dynamic Programming，

其他的都不要考虑，什么递归呀的都是浮云（当然带记忆数组的递归写法除外，因为这也可以算是 DP 的一种），

千辛万苦的写了递归结果拿到 OJ 上妥妥 Time Limit Exceeded，能把人气昏了，所以还是直接就考虑 DP 解法省事些。

一般来说字符串匹配问题都是更新一个二维 dp 数组，核心就在于找出状态转移方程。那么我们还是从题目中给的例子出发吧，手动写出二维数组 dp 如下：

首先，这道题的大前提是字符串 s1 和 s2 的长度和必须等于 s3 的长度，如果不等于，肯定返回 false。那么当 s1 和 s2 是空串的时候，s3 必然是空串，

则返回 true。所以直接给 dp[0][0] 赋值 true，然后若 s1 和 s2 其中的一个为空串的话，那么另一个肯定和 s3 的长度相等，则按位比较，

若相同且上一个位置为 True，赋 True，其余情况都赋 False，这样的二维数组 dp 的边缘就初始化好了。下面只需要找出状态转移方程来更新整个数组即可，

我们发现，在任意非边缘位置 dp[i][j] 时，它的左边或上边有可能为 True 或是 False，两边都可以更新过来，只要有一条路通着，

那么这个点就可以为 True。那么我们得分别来看，如果左边的为 True，

那么我们去除当前对应的 s2 中的字符串 s2[j - 1] 和 s3 中对应的位置的字符相比（计算对应位置时还要考虑已匹配的s1中的字符），为 s3[j - 1 + i], 

如果相等，则赋 True，反之赋 False。 而上边为 True 的情况也类似，所以可以求出状态转移方程为：

dp[i][j] = (dp[i - 1][j] && s1[i - 1] == s3[i - 1 + j]) || (dp[i][j - 1] && s2[j - 1] == s3[j - 1 + i]);

其中 dp[i][j] 表示的是 s2 的前 i 个字符和 s1 的前 j 个字符是否匹配 s3 的前 i+j 个字符，根据以上分析，可写出代码如下：
**/

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        
        int n1 = s1.length(), n2 = s2.length();
        
        boolean[][] dp = new boolean[n1 + 1][n2 + 1];
        dp[0][0] = true;
        
        for (int i = 1; i <= n1; i++) {
            dp[i][0] = dp[i - 1][0] && (s1.charAt(i - 1) == s3.charAt(i - 1));
        }
        
        for (int j = 1; j <= n2; j++) {
            dp[0][j] = dp[0][j - 1] && (s2.charAt(j - 1) == s3.charAt(j - 1));
        }
        
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i - 1 + j) || dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1 + i));
            }
        }
        
        return dp[n1][n2];
    }
}

public boolean isInterleave(String s1, String s2, String s3) {
    char[] c1 = s1.toCharArray(), c2 = s2.toCharArray(), c3 = s3.toCharArray();
	int m = s1.length(), n = s2.length();
	if(m + n != s3.length()) return false;
	return dfs(c1, c2, c3, 0, 0, 0, new boolean[m + 1][n + 1]);
}

public boolean dfs(char[] c1, char[] c2, char[] c3, int i, int j, int k, boolean[][] invalid) {
	if(invalid[i][j]) return false;
	if(k == c3.length) return true;
	boolean valid = 
	    i < c1.length && c1[i] == c3[k] && dfs(c1, c2, c3, i + 1, j, k + 1, invalid) || 
        j < c2.length && c2[j] == c3[k] && dfs(c1, c2, c3, i, j + 1, k + 1, invalid);
	if(!valid) invalid[i][j] = true;
    return valid;
}
