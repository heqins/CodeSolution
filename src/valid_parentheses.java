/**
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true
Example 2:

Input: "()[]{}"
Output: true
Example 3:

Input: "(]"
Output: false
Example 4:

Input: "([)]"
Output: false
Example 5:

Input: "{[]}"
Output: true
**/

/**
这道题让我们验证输入的字符串是否为括号字符串，包括大括号，中括号和小括号。这里需要用一个栈，
开始遍历输入字符串，如果当前字符为左半边括号时，则将其压入栈中，如果遇到右半边括号时，
若此时栈为空，则直接返回 false，如不为空，则取出栈顶元素，若为对应的左半边括号，则继续循环，反之返回 false，代码如下：
**/

import java.util.Stack;

public class valid_parentheses {
    public boolean isValid(String s) {
        Stack<Character> str = new Stack<>();
        if (s == null) return true;
        for (char c: s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                str.push(c);
            }else if (c == ')' || c == ']' || c == '}') {
                if (str.isEmpty()) {
                    return false;
                }else{
                    if ((str.peek() == '(' && c == ')') || (str.peek() == '[' && c == ']') || (str.peek() == '{') && c == '}') {
                        str.pop();
                    }else {
                        return false;
                    }
                }
            }
        }
        if (str.isEmpty()) {
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        String test = "()[{}]]";
        valid_parentheses vp = new valid_parentheses();
        System.out.println(vp.isValid(test));
    }
}
