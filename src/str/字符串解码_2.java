package str;

import java.util.Stack;

public class 字符串解码_2 {

    /**
     * 给定一个经过编码的字符串，返回它解码后的字符串。
     *
     * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
     *
     * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
     *
     * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
     */

    public String decodeString(String s) {
        char[] chs = s.toCharArray();

        Stack<Integer> numStack = new Stack();
        Stack<StringBuilder> strStack = new Stack();

        StringBuilder sb = new StringBuilder();
        int num = 0;

        for (char ch: chs) {
            if (ch == ']') {
                int times = numStack.isEmpty() ? 1 : numStack.pop();
                StringBuilder sb2 = new StringBuilder();
                for (int i = 0; i < times; i++) {
                    sb2.append(sb);
                }

                // 当前这个括号前的字符串跳出，append上当前括号内的
                sb = strStack.pop();

                sb.append(sb2);
            } else if (ch <= '9' && ch >= '0'){
                // 数字不仅仅只是1位
                num = num * 10 + (ch - '0');
            } else if (ch == '['){
                numStack.push(num);
                num = 0;
                // 当遇到左括号的时候，保存当前位置的字母，重置sb
                strStack.push(sb);
                sb = new StringBuilder();
            } else {
                // 只是字母的情况
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}
