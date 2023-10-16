package list;

public class 循环有序链表的插入 {

    /**
     * 给定循环单调非递减列表中的一个点，写一个函数向这个列表中插入一个新元素 insertVal ，使这个列表仍然是循环升序的。
     *
     * 给定的可以是这个列表中任意一个顶点的指针，并不一定是这个列表中最小元素的指针。
     *
     * 如果有多个满足条件的插入位置，可以选择任意一个位置插入新的值，插入后整个列表仍然保持有序。
     *
     * 如果列表为空（给定的节点是 null），需要创建一个循环有序列表并返回这个节点。否则。请返回原先给定的节点。
     */
    public Node insert(Node head, int insertVal) {
        Node node = new Node(insertVal);

        // 如果只有一个节点，或无有效节点
        if (head == null) {
            node.next = node;
            return node;
        }else if (head.next == head) {
            head.next = node;
            node.next = head;
            return head;
        }else {
            insertCore(head, node);
        }

        return head;
    }

    private void insertCore(Node head, Node node) {
        Node cur = head;
        Node next = head.next;
        Node biggest = head;

        // next != head 避免无限循环，新增的值是最大或最小
        // node.next = head表示回到头节点
        while (!(cur.val <= node.val && node.val <= next.val) && next != head) {
            cur = next;
            next = next.next;

            if (cur.val >= biggest.val) {
                biggest = cur;
            }
        }

        if (cur.val <= node.val && node.val <= next.val) {
            node.next = cur.next;
            cur.next = node;
        }else {
            node.next = biggest.next;
            biggest.next = node;
        }
    }
}
