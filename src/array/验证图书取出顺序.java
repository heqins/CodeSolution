package array;

import java.util.Stack;

public class 验证图书取出顺序 {

    /**
     * 现在图书馆有一堆图书需要放入书架，并且图书馆的书架是一种特殊的数据结构，只能按照 一定 的顺序 放入 和 拿取 书籍。
     *
     * 给定一个表示图书放入顺序的整数序列 putIn，请判断序列 takeOut 是否为按照正确的顺序拿取书籍的操作序列。
     * 你可以假设放入书架的所有书籍编号都不相同。
     */
    public boolean validateBookSequences(int[] putIn, int[] takeOut) {
        Stack<Integer> stack = new Stack();
        int i = 0;

        for (int num: putIn) {
            stack.push(num);

            while (!stack.isEmpty() && stack.peek() == takeOut[i]) {
                i++;
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
