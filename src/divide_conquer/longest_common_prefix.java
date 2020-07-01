/**
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"

Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.

Note:

All given inputs are in lowercase letters a-z.

**/

/**
把所有字符串分成两组，分别去比较，最后都剩一个的时候，两组在比较。Time： O(n*m), Space: O(n*logm)
**/

public class longest_common_prefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {return "";}
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.length() == 0) {
                    return "";
                }
            }
        }

        return prefix;
    }

    // divide and conquer
    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {return "";}
        String res = longestCommonPrefix2(strs, 0, strs.length - 1);
        return res;
    }

    public String longestCommonPrefix2(String[] strs, int left, int right) {
        if (left == right) {
            return strs[left];
        }
        else {
            int mid = (left + right) / 2;
            String leftStr = longestCommonPrefix2(strs, left, mid);
            String rightStr = longestCommonPrefix2(strs, mid + 1, right);
            return CommonPrefix(leftStr, rightStr);
        }
    }

    public String CommonPrefix(String left, String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if (left.charAt(i) != right.charAt(i)) {
                return left.substring(0, i);
            }
        }
        return left.substring(0, min);
    }

    public static void main(String[] args) {
        longest_common_prefix lcp = new longest_common_prefix();
        String[] test = new String[]{"flower","flow","flight"};
        System.out.println(lcp.longestCommonPrefix2(test));
    }
}
