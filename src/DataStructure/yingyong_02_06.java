package DataStructure;

public class yingyong_02_06 {
    private static class SeqQueue2 {
        private int front = -1;
        private int length;
        private int MAX_SIZE = 999;
        int[] queue;
        public SeqQueue2(){
            this.queue = new int[MAX_SIZE];
            this.length = 0;
        }
    }
    public boolean isFull(SeqQueue2 q) {
        return q.length == q.MAX_SIZE;
    }

    public boolean isEmpty(SeqQueue2 q) {
        return q.length == 0;
    }

    public void push(SeqQueue2 q, int x) {
        if (isFull(q)) {
            System.out.println("Queue Full!");
        }else {
            q.queue[(q.front + 1) % q.MAX_SIZE] = x;
            q.length++;
        }
    }

    public int poll(SeqQueue2 q) {
        if (isEmpty(q)) {
            System.out.println("Queue Empty!");
            return -1;
        }else {
            int value = q.queue[q.front];
            q.front = (q.front + 1) % q.MAX_SIZE;
            q.length--;
            return value;
        }
    }

    public static void main(String[] args) {
        SeqQueue2 queue = new SeqQueue2();
        yingyong_02_06 yy_02_06 = new yingyong_02_06();
        yy_02_06.push(queue, 2);
    }
}
