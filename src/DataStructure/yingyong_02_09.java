package DataStructure;

import java.util.Stack;

public class yingyong_02_09 {
    private static int compute(char[] expression) {
        Stack<Integer> sn = new Stack<>();
        Stack<Character> sop = new Stack<>();

        for (char c: expression){
            if (isNumber(c)) {
                sn.push(c - '0');
            } else if (c == '+' || c == '-') {
                while (!sop.isEmpty() && (sop.peek() == '*' || sop.peek() == '/')) {
                    int b = sn.pop();
                    int a = sn.pop();
                    sn.push(getAnswer(a, sop.pop(), b));
                }
                sop.push(c);
            } else if (c == '*' || c == '/') {
                if (!sop.isEmpty()) {
                    sop.push(c);
                }
            } else if (c == ')') {
                while (!sop.isEmpty() && sop.peek() != '(') {
                    int b = sn.pop();
                    int a = sn.pop();
                    sn.push(getAnswer(a, sop.pop(), b));
                }
                sop.pop();
            }else {
                sop.push('(');
            }
        }

        while (!sop.isEmpty()) {

        }

        return sn.peek();
        }

    private static boolean isNumber(char c) {
        if ((c - '0') > -1 && (c - '0') < 10) {
                return true;
        }
        return false;
    }

    private static int getAnswer(int a, char operator, int b) {
        switch (operator) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return a / b;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(compute("2+3+(5*3)-(1+2*4/2)-3-1+9-9-(4*4)".toCharArray()));
    }
}
