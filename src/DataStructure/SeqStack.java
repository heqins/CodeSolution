package DataStructure;

public class SeqStack {
    private int MAX_SIZE;
    private int[] elems;
    int top = -1;
    int len;
    public SeqStack(int size) {
        this.MAX_SIZE = size;
        this.elems = new int[this.MAX_SIZE];
        this.len = 0;
    }

    public void push(int x) {
        if (!isFull()) {
            this.elems[++top] = x;
            this.len++;
        }else {
            System.out.println("Stack Over Flow!");
        }
    }

    public boolean isEmpty() {
        return this.len == 0;
    }

    public boolean isFull() {
        return this.len == this.MAX_SIZE;
    }

    public int pop() {
        if (!isEmpty()) {
            int value = this.elems[this.top--];
            this.len--;
            return value;
        }else {
            System.out.println("Stack Is Empty!");
            return Integer.MIN_VALUE;
        }
    }
}
