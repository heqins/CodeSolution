package DataStructure;

public class yingyong_02_06 {
    public boolean isEmpty(SeqQueue q) {
        return q.length == 0;
    }

    public boolean isFull(SeqQueue q) {
        return q.length == q.maxSize;
    }

    public void push(SeqQueue q, int x) throws Exception{
        if (!isFull(q)) {
            q.elems[(q.front + q.length) % q.maxSize] = x;
            q.length++;
        }else {
            throw new Exception("queue is full");
        }
    }

    public int pop(SeqQueue q) throws Exception{
        if (!isEmpty(q)) {
            int x = q.elems[q.front];
            q.front = (q.front + 1) % q.maxSize;
            q.length--;
            return x;
        }else {
            throw new Exception("queue is empty");
        }
    }
}
