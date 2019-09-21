package DataStructure;

import java.util.Stack;

public class yingyong_02_09 {
    private static int compute(char[] expression) {
        // 负号问题， 连续减号问题
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
                sop.push(c);
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

        System.out.println(sop.toString());
        System.out.println(sn.toString());

        while (!sop.isEmpty()) {
            int b = sn.pop();
            int a = sn.pop();
            sn.push(getAnswer(a, sop.pop(), b));
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
        System.out.println(compute("((3+5*2)+3)/5+(-6)/4*2+3".toCharArray()));
    }
}
