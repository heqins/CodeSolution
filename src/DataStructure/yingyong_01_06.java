package DataStructure;

public class yingyong_01_06 {
        public static void insert(ListNode head, int e) {
            ListNode p = head.next;
            ListNode prev = head;
            while (p != null) {
                if (p.val <= e) {
                    prev = p;
                    p = p.next;
                }else {
                    ListNode temp = new ListNode(e);
                    prev.next = temp;
                    temp.next = p;
                    System.out.println(p.val);
                    break;
                }
            }
        }

        public static void remove(ListNode head, int e) {
            ListNode p = head.next;
            ListNode prev = head;
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
            ListNode head = new ListNode(-1);
            ListNode h1 = new ListNode(1);
            ListNode h2 = new ListNode(3);
            ListNode h3 = new ListNode(5);
            head.next = h1;
            h1.next = h2;
            h2.next = h3;
            insert(head, 6);
//            System.out.println(head.next.next.next.val);
            remove(head, 1);
            System.out.println(head.next.val);
        }
    }

