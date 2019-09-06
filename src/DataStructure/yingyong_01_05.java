package DataStructure;

public class yingyong_01_05 {
        // List: no head
        public void insert(ListNode head, int e) {
            ListNode p = head.next;
            while (p != null) {
                if (p.val > e) {
                    p = p.next;
                }else {
                    ListNode temp = new ListNode(e);
                    temp.next = p.next;
                    p.next = temp;
                }
            }
        }

        public void remove(ListNode head, int e) {
            ListNode p = head;
            ListNode prev = null;
            while (p != null) {
                if (p.val == e) {
                    prev.next = p.next;
                    break;
                }

                prev = p;
                p = p.next;
            }
        }

        public static void main(String[] args) {
            ListNode head = new ListNode(21);
            ListNode h1 = new ListNode(1);
            ListNode h2 = new ListNode(2);
            ListNode h3 = new ListNode(2);
            head.next = h1;
            h1.next = h2;
            h2.next = h3;
            yingyong_01_05 y0106 = new yingyong_01_05();
            y0106.remove(head, 21);
            System.out.println(head.val);
        }
    }

