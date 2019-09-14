package DataStructure;

public class yingyong_02_04 {
    final static int MAX_SIZE = Integer.MAX_VALUE;
    private int[] stack;
    int top1 = -1;
    int top2 = MAX_SIZE;
    int len = 0;
    public yingyong_02_04(int size) {
        this.stack = new int[size];
    }

    public void push(int x, int num) throws Exception {
        if (top1 + 1 == top2) {
            throw new Exception("over flow");
        }else {
            if (num == 0) {
                this.stack[++top1] = x;
            }else {
                this.stack[--top2] = x;
            }
        }
    }

    public int pop(int num) throws Exception {
        if (this.isEmpty(num)) {
            throw new Exception("stack empty");
        }else {
            if (num == 0) {
                return this.stack[this.top1--];
            } else {
                return this.stack[this.top2++];
            }
        }
    }

    public boolean isEmpty(int num) {
        if (num == 0) {
            return this.top1 == -1;
        }else {
            return this.top2 == this.MAX_SIZE;
        }
    }
}
