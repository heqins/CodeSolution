package DataStructure;

public class SeqQueue {
    int front, rear;
    int maxSize;
    int[] elems;
    int length;
    public SeqQueue(int size) {
        maxSize = size;
        this.elems = new int[maxSize];
        this.length = 0;
    }
}
