package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class copy_list_with_random_pointer {
    public Node copyRandomList(Node head) {
       if (head == null) return null;
       Node c = head;
       while (c != null) {
           Node next= c.next;
           c.next = new Node(c.val, null, null);
           c.next.next = next;
           c = next;
       }

       c = head;
       while (c != null) {
           if (c.random != null) {
               c.next.random = c.random.next;
           }
           c = c.next.next;
       }

       c = head;
       Node copyHead = head.next;
       Node copy = copyHead;
       while (copy.next != null) {
           c.next = c.next.next;
           c = c.next;

           copy.next = copy.next.next;
           copy = copy.next;
       }
       c.next = c.next.next;

       return copyHead;
    }
}
