package Str;

import java.util.Stack;

public class basic_calcaulator {
    public int calculate2(String s) {
        s = s + " "; // so that we can finish all processing in one for loop
        Stack<Integer> stack = new Stack<>(); // to store last value and sign before any parentheses
        int ret = 0;  // current result within one priority (in the same parentheses)
        int cur = 0;  // current number
        int sign = 1; // current sign
        for(int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if(Character.isDigit(ch)) { // always process digit first
                cur = cur * 10 + (int)(ch - '0');
//                System.out.println("i:"+i+" "+"ret:"+ret+" "+"cur:"+cur+" "+"sign:"+sign);
            }
            else { // if not digit,
                ret = ret + cur * sign; // cur has ended
//                System.out.println("i:"+i+" "+"ret:"+ret+" "+"cur:"+cur+" "+"sign:"+sign);
                if(ch == '(') { // a new level, push ret and sign to stack
                    stack.push(ret);
                    stack.push(sign);
                    ret = 0;  // start a new result in this level
                }
                else if(ch == ')') { // finish one level
                    ret = ret * stack.pop(); // sign
                    ret = ret + stack.pop(); // process result before sign
                }
                cur = 0;                     // reset cur
                sign = (ch == '-') ? -1 : 1; // reset sign
            }
        }
        return ret;
    }

    public int calculate(String s) {
        if (s.length() == 0) {return 0;}
        int[] p = {0};

        s = "(" + s + ")";
        return eval(s, p);
    }

    public int eval(String s, int[] p) {
        int num = 0;
        int sign = 1;
        int res = 0;
        int i = p[0];
        while (i < s.length()) {
            char c = s.charAt(i);
            switch(c) {
                case '+': res = res + sign * num; num = 0; sign = 1; i++; break;
                case '-': res = res + sign * num; num = 0; sign = -1; i++; break;
                case '(': p[0] = i + 1; res = res + sign * eval(s, p); i = p[0]; break;
                case ')': p[0] = i + 1; return res + num * sign;
                case ' ': i++; continue;
                default: num = num * 10 + (c - '0'); i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String test = "(1+2)-3+((1-2)+(4+5))";
        basic_calcaulator bc = new basic_calcaulator();
        System.out.println(bc.calculate(test));
    }
}
