package DataStructure;

public class yingyong_01_05 {
        public static void insert(ListNode head, int e, int index) {
            ListNode temp = new ListNode(e);
            if (index == 0) {
                int t = head.val;
                head.val = temp.val;
                temp.val = t;
                temp.next = head.next;
                head.next = temp;
            }else {
                ListNode p = head;
                int count = 0;
                while (p != null && count < index - 1) {
                    p = p.next;
                    count++;
                }
                temp.next = p.next;
                p.next = temp;
            }
        }

        public static void remove(ListNode head, int index) {
            if (index == 0) {
                head = head.next;
            }else {
                int count = 0;
                ListNode p = head;
                while (count < index - 1 && p != null) {
                    p = p.next;
                    count++;
                }
                p.next = p.next.next;
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
            insert(head, 45, 1);
//            insert(head, 45, 2);
            remove(head, 4);
            System.out.println(head);
        }
    }

