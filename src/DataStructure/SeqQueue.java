package DataStructure;

public class SeqQueue {
    // 循环队列
    private int front, rear;
    private int MAX_SIZE;
    private int[] elems;
    int len;
    public SeqQueue(int size) {
        this.MAX_SIZE = size;
        this.elems = new int[this.MAX_SIZE];
        this.front = this.rear = 0;
        this.len = 0;
    }

    public void offer(int x) {
        if (!isFull()) {
            this.elems[this.rear] = x;
            this.rear =  (this.rear + 1) % this.MAX_SIZE;
            this.len++;
        }else {
            System.out.println("Queue Over Flow!");
        }
    }

    public int poll() {
        if (!isEmpty()) {
            int value = this.elems[this.front];
            this.front = (this.front + 1) % this.MAX_SIZE;
            this.len--;
            return value;
        }else {
            return Integer.MIN_VALUE;
        }
    }

    public boolean isEmpty() {
        return this.front == this.rear;
    }

    public boolean isFull() {
        return (this.rear + 1) % this.MAX_SIZE == this.front;
    }
}
