package DataStructure;

import java.util.PriorityQueue;
import java.util.Stack;

public class yingyong_02_05 {
    Stack<Integer> s1;
    Stack<Integer> s2;

    public void push(int x) {
        this.s1.push(x);
    }

    public int pop() {
        while (!this.s1.isEmpty()) {
            this.s2.push(this.s1.pop());
        }

        int x = s1.pop();

        while (!this.s2.isEmpty()) {
            this.s1.push(this.s2.pop());
        }

        return x;
    }

    public boolean isEmpty() {
        return this.s1.isEmpty();
    }
}
