package list;

public class 展平多级双向链表 {

    /**
     * 问题：在一个多级双向链表中，节点除了有两个指针分别指向
     * 前后两个节点，还有一个指针指向它的子链表，并且子链表也是一
     * 个双向链表，它的节点也有指向子链表的指针。请将这样的多级双
     * 向链表展平成普通的双向链表，即所有节点都没有子链表。
     * @param args
     */

    public static Node flatten(Node head) {
        flattenGetTail(head);
        return head;
    }

    public static Node flattenGetTail(Node head) {
        Node cur = head;
        Node tail = null;

        while (cur != null) {
            Node next = cur.next;
            if (cur.child != null) {
                Node child = cur.child;
                Node childTail = flattenGetTail(cur.child);

                child.prev = cur;
                childTail.next = next;

                cur.child = null;

                if (next != null) {
                    next.prev = childTail;
                }

                cur.next = child;

                tail = childTail;
            }else {
                tail = cur;
            }

            cur = cur.next;
        }

        return tail;
    }
}
