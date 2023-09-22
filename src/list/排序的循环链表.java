package list;

public class 排序的循环链表 {

    /**
     * 问题：在一个循环链表中节点的值递增排序，请设计一个算法
     * 在该循环链表中插入节点，并保证插入节点之后的循环链表仍然是
     * 排序的。例如，图4.15（a）所示是一个排序的循环链表，插入一个
     * 值为4的节点之后的链表如图4.15（b）所示。
     * @param args
     */
    public static void main(String[] args) {

    }

    public Node solve(Node head, int insertVal) {
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
