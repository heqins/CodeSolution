package str;

import java.util.Stack;

public class 删除字符串中的所有相邻重复项 {

    /**
     * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
     *
     * 在 S 上反复执行重复项删除操作，直到无法继续删除。
     *
     * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
     */

    public static void main(String[] args) {
        String abbaca = removeDuplicates("abbaca");
        System.out.println("test");
    }

    public static String removeDuplicates(String s) {

        // 题目的关键在于 删除重复项，因此重点在于找到所有重复项，包含 因为删除而产生的重复项，
        // 因此可以使用栈实现。 每次添加时比较是否与栈顶元素相同
        //若相同则删除栈顶元素且不插入
        //若不相同则插入新元素

        StringBuilder sb = new StringBuilder();

        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()) {
            if (stack.isEmpty() || stack.peek() != c) {
                stack.push(c);
            }else {
                stack.pop();
            }
        }

        for (Character c: stack) {
            sb.append(c);
        }
        return sb.toString();
    }
}
