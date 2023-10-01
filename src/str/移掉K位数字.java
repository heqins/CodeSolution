package str;

import java.util.Stack;

public class 移掉K位数字 {

    /**
     *  给你一个以字符串表示的非负整数 num 和一个整数 k ，
     *  移除这个数中的 k 位数字，使得剩下的数字最小。请你以字符串形式返回这个最小的数字。
     */
    public String removeKdigits(String num, int k) {
        // 处理特殊情况
        if (num.length() == k) {
            return "0";
        }

        Stack<Integer> stack = new Stack();
        char[] chs = num.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < chs.length; i++) {
            Integer temp = chs[i] - '0';
            // 单调栈，从栈底到栈顶单调递增，如果有小于栈顶的则循环出栈，我们希望高位的元素尽可能小
            while (k != 0 && !stack.isEmpty() && temp < stack.peek()) {
                stack.pop();
                k--;
            }

            if (stack.isEmpty() && temp == 0) {
                continue;
            }

            stack.push(temp);
        }

        while (!stack.isEmpty() && k > 0) {
            stack.pop();
            k--;
        }

        if (stack.isEmpty()) {
            return "0";
        }

        while (!stack.isEmpty()) {
            sb.append(String.valueOf(stack.pop()));
        }

        return sb.reverse().toString();
    }
}
