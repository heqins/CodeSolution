/**
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:

P     I    N
A   L S  I G
Y A   H R
P     I
**/

/**
可以发现，除了第一行和最后一行没有中间形成之字型的数字外，其他都有，而首位两行中相邻两个元素的 index 之差跟行数是相关的，
为  2*nRows - 2, 根据这个特点，可以按顺序找到所有的黑色元素在元字符串的位置，将他们按顺序加到新字符串里面。
对于红色元素出现的位置（Github 上可能无法正常显示颜色，请参见博客园上的帖子）也是有规律的，每个红色元素的位置为 j + 2 x numRows-2 - 2 x i,
其中，j为前一个黑色元素的 index，i为当前行数。 比如当 n = 4 中的那个红色5，它的位置为 1 + 2 x 4-2 - 2 x 1 = 5，
为原字符串的正确位置。知道了所有黑色元素和红色元素位置的正确算法，就可以一次性的把它们按顺序都加到新的字符串里面。代码如下：
**/

class Solution {
    public String convert(String s, int numRows) {
        if (numRows <= 1) return s;
        int len = s.length();
        StringBuilder res = new StringBuilder();
        
        int size = 2 * numRows - 2;
        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < len; j += size) {
                res.append(s.charAt(j));
                int pos = j + size - 2 * i;
                if (i != 0 && i != numRows - 1 && pos < len) res.append(s.charAt(pos));
            }
        }
        
        return res.toString();
    }
}
