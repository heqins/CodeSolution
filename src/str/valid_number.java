/**
请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"0123"都表示数值，但"12e"、"1a3.14"、"1.2.3"、"+-5"、"-1E-16"及"12e+5.4"都不是。

 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
**/

/**
[]  ： 字符集合
()  ： 分组，在这里是为了让表达式更清晰
?   ： 重复 0 ~ 1 次
+   ： 重复 1 ~ n 次
*   ： 重复 0 ~ n 次
.   ： 任意字符
\\. ： 转义后的 .
\\d ： 任意数字
**/

class Solution {
    public boolean isNumber(String s) {
        if (s.length() < 0 || s == null) return false;
        
        /**
        We want to use regex to solve this problem.

        First, let us consider numbers without sign and e.
        Here are four cases: 0, 0., .0, 0.0. And we can divide them into two cases: {0, 0., 0.0}, {.0}.
        In the first case, we have regular expression: \\d+(\\.\\d*)?, and in the second case we have \\.\\d+
        So, the numbers without sign and e can be written to \\d+(\\.\\d*)?|\\.\\d+.

        Second, let us consider e, and there are three cases: e1, e+1, e-1, which can be written to e[+-]?\\d+.

        Third, let us consider sign, which can be written to [+-]?

        In a word, valid number can be written to [+-]?(\\d+(\\.\\d*)?|\\.\\d+)(e[+-]?\\d+)?,
        * */
        
        return s.trim().matches("[+-]?(\\d+(\\.\\d*)?|\\.\\d+)(e[+-]?\\d+)?");  
    }
}
