/**
Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

Example:

Input: "aab"
Output: 1
Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
**/
/**
这道题是让找到把原字符串拆分成回文串的最小切割数，如果我们首先考虑用brute force来做的话就会十分的复杂，因为我们不但要判断子串是否是回文串，

而且还要找出最小切割数，情况会非常的多，不好做。所以对于这种玩字符串且是求极值的题，就要祭出旷古神器动态规划Dynamic Programming了，

秒天秒地秒空气，DP在手天下我有。好，吹完一波后，开始做题。DP解法的两个步骤，定义dp数组和找状态转移方程。首先来定义dp数组，

这里使用最直接的定义方法，一维的dp数组，其中dp[i]表示子串 [0, i] 范围内的最小分割数，那么我们最终要返回的就是 dp[n-1] 了，

这里先加个corner case的判断，若s串为空，直接返回0，OJ的test case中并没有空串的检测，但博主认为还是加上比较好，毕竟空串也算是回文串的一种，

所以最小分割数为0也说得过去。接下来就是大难点了，如何找出状态转移方程。

如何更新dp[i]呢，前面说过了其表示子串 [0, i] 范围内的最小分割数。那么这个区间的每个位置都可以尝试分割开来，所以就用一个变量j来从0遍历到i，

这样就可以把区间 [0, i] 分为两部分，[0, j-1] 和 [j, i]，那么suppose我们已经知道区间 [0, j-1] 的最小分割数 dp[j-1]，因为我们是从前往后更新的，

而 j 小于等于 i，所以 dp[j-1] 肯定在 dp[i] 之前就已经算出来了。这样我们就只需要判断区间 [j, i] 内的子串是否为回文串了，

是的话，dp[i] 就可以用 1 + dp[j-1] 来更新了。判断子串的方法用的是之前那道 Palindromic Substrings 一样的方法，使用一个二维的dp数组p，

其中 p[i][j] 表示区间 [i, j] 内的子串是否为回文串，其状态转移方程为 p[i][j] = (s[i] == s[j]) && p[i+1][j-1]，

其中 p[i][j] = true if [i, j]为回文。这样的话，这道题实际相当于同时用了两个DP的方法，确实难度不小呢。

第一个for循环遍历的是i，此时我们现将 dp[i] 初始化为 i，因为对于区间 [0, i]，就算我们每个字母割一刀（怎么听起来像凌迟？！），

最多能只用分割 i 次，不需要再多于这个数字。但是可能会变小，所以第二个for循环用 j 遍历区间 [0, j]，根据上面的解释，

我们需要验证的是区间 [j, i] 内的子串是否为回文串，那么只要 s[j] == s[i]，并且 i-j < 2 或者 p[j+1][i-1] 为true的话，

先更新 p[j][i] 为true，然后在更新 dp[i]，这里需要注意一下corner case，当 j=0 时，我们直接给 dp[i] 赋值为0，因为此时能运行到这，

说明 [j, i] 区间是回文串，而 j=0， 则说明 [0, i] 区间内是回文串，这样根本不用分割啊。若 j 大于0，则用 dp[j-1] + 1 来更新 dp[i]，

最终返回 dp[n-1] 即可，参见代码如下：
**/

/**
在刚开始的时候博主提到了自己写的 DP 的方法比较复杂，为什么呢，因为博主的 dp[i][j] 定义的是范围 [i, j] 之间的子字符串的个数，

‘这样其实还需要一个二维数组来记录子字符串 [i, j] 是否是回文串，那还不如直接就将 dp[i][j] 定义成子字符串 [i, j] 是否是回文串就行了，

然后i从 n-1 往0遍历，j从i往 n-1 遍历，然后看 s[i] 和 s[j] 是否相等，这时候需要留意一下，有了 s[i] 和 s[j] 相等这个条件后，

i和j的位置关系很重要，如果i和j相等了，则 dp[i][j] 肯定是 true；如果i和j是相邻的，那么 dp[i][j] 也是 true；如果i和j中间只有一个字符，

那么 dp[i][j] 还是 true；如果中间有多余一个字符存在，则需要看 dp[i+1][j-1] 是否为 true，若为 true，那么 dp[i][j] 就是 true。

赋值 dp[i][j] 后，如果其为 true，结果 res 自增1，参见代码如下：

**/

class Solution {
    public int minCut(String s) {
        if (s.length() == 0) return 0;
        int n = s.length();
        boolean[][] p = new boolean[n][n];
        int[] dp = new int[n];
        
        for (int i = 0; i < n; ++i) {
            dp[i] = i;
            for (int j = 0; j <= i; ++j) {
                if (s.charAt(i) == s.charAt(j) && (i - j < 2 || p[j + 1][i - 1])) {
                    p[j][i] = true;
                    dp[i] = (j == 0) ? 0 : Math.min(dp[i], dp[j - 1] + 1);
                }
            }
        }
        return dp[n - 1];
    }
}
