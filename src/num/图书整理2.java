package num;

import java.util.Stack;

public class 图书整理2 {

    /**
     * 读者来到图书馆排队借还书，图书管理员使用两个书车来完成整理借还书的任务。书车中的书从下往上叠加存放，
     * 图书管理员每次只能拿取书车顶部的书。排队的读者会有两种操作：
     *
     * push(bookID)：把借阅的书籍还到图书馆。
     * pop()：从图书馆中借出书籍。
     * 为了保持图书的顺序，图书管理员每次取出供读者借阅的书籍是 最早 归还到图书馆的书籍。你需要返回 每次读者借出书的值 。
     *
     * 如果没有归还的书可以取出，返回 -1 。
     */

    Stack<Integer> stack1 = new Stack();
    Stack<Integer> stack2 = new Stack();

    public 图书整理2() {

    }

    public void appendTail(int value) {
        stack2.push(value);
    }

    public int deleteHead() {
        if (stack2.isEmpty()) {
            return -1;
        }

        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }

        int val = stack1.isEmpty() ? -1 : stack1.peek();
        stack1.pop();

        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        return val;
    }
}
