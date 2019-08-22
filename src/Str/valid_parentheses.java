package Str;

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
