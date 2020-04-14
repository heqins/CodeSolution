/**
这道求最长有效括号比之前那道 Valid Parentheses 难度要大一些，这里还是借助栈来求解，需要定义个 start 变量来记录合法括号串的起始位置，

遍历字符串，如果遇到左括号，则将当前下标压入栈，如果遇到右括号，如果当前栈为空，则将下一个坐标位置记录到 start，如果栈不为空，

则将栈顶元素取出，此时若栈为空，则更新结果和 i - start + 1 中的较大值，否则更新结果和 i - st.top() 中的较大值，参见代码如下：

**/

/**
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

Example 1:

Input: "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()"
Example 2:

Input: ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()"
**/

class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length(), start = 0, res = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);   
            }else if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    start = i + 1;
                }else {
                    stack.pop();
                    res = stack.isEmpty() ? Math.max(res, i - start + 1) : Math.max(res, i - stack.peek());
                }
            }
        }
        
        return res;
    }
}

