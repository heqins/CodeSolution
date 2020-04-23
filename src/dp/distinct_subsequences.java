/**
Given a string S and a string T, count the number of distinct subsequences of S which equals T.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

It's guaranteed the answer fits on a 32-bit signed integer.

Example 1:

Input: S = "rabbbit", T = "rabbit"
Output: 3
Explanation:
As shown below, there are 3 ways you can generate "rabbit" from S.
(The caret symbol ^ means the chosen letters)

rabbbit
^^^^ ^^
rabbbit
^^ ^^^^
rabbbit
^^^ ^^^
Example 2:

Input: S = "babgbag", T = "bag"
Output: 5
Explanation:
As shown below, there are 5 ways you can generate "bag" from S.
(The caret symbol ^ means the chosen letters)

babgbag
^^ ^
babgbag
^^    ^
babgbag
^    ^^
babgbag
  ^  ^^
babgbag
    ^^^
**/

/**
首先，若原字符串和子序列都为空时，返回1，因为空串也是空串的一个子序列。若原字符串不为空，而子序列为空，也返回1，

因为空串也是任意字符串的一个子序列。而当原字符串为空，子序列不为空时，返回0，因为非空字符串不能当空字符串的子序列。

理清这些，二维数组 dp 的边缘便可以初始化了，下面只要找出状态转移方程，就可以更新整个 dp 数组了。

我们通过观察上面的二维数组可以发现，当更新到 dp[i][j] 时，dp[i][j] >= dp[i][j - 1] 总是成立，

再进一步观察发现，当 T[i - 1] == S[j - 1] 时，dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1]，若不等，

dp[i][j] = dp[i][j - 1]，所以，综合以上，递推式为：
**/

class Solution {
    public int numDistinct(String S, String T) {
        int sl = S.length();
	    int tl = T.length();
	
	    int [][] dp = new int[tl+1][sl+1];

	    for(int i=0; i<=sl; ++i){
		    dp[0][i] = 1;
	    }
	
	    for(int t=1; t<=tl; ++t){
		
		    for(int s=1; s<=sl; ++s){
			    if(T.charAt(t-1) != S.charAt(s-1)){
				    dp[t][s] = dp[t][s-1];
			    }else{
				    dp[t][s] = dp[t][s-1] + dp[t-1][s-1];
			    }
		    }	
	    }
	
	    return dp[tl][sl];
        }
}
