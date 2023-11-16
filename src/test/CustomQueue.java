package test;

public class CustomQueue<T> {

    private class Node<T> {
        private T data;

        private Node next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<T> head;

    private Node<T> last;

    public void enqueue(T data) {
        Node<T> node = new Node<>(data, null);
        if (head == null) {
            head = node;
        } else {
            last.next = node;
        }
        last = node;
    }

    public T dequeue() {
        if (head == null) {
            return null;
        }

        T data = head.data;
        head = head.next;

        if (head == null) {
            last = null;
        }

        return data;
    }

    public static void main(String[] args) {
        CustomQueue<Integer> queue = new CustomQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println(queue.dequeue());

        System.out.println(queue.dequeue());

        System.out.println(queue.dequeue());
    }
}
