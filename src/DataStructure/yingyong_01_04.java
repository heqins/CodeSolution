package DataStructure;

public class yingyong_01_04 {
        public static ListNode getNode(ListNode head, int i) {
            if (head == null) {
                return null;
            }
            ListNode p = head;
            int count = 0;
            while (count < i && p != null) {
                p = p.next;
                count += 1;
            }
            return p;
        }
        public static int elemCount(ListNode head, int e) {
            int count = 0;

            ListNode p = head.next;

            while (p != null) {
                if (p.val == e) {
                    count ++;
                }
                p = p.next;
            }

            return count;
        }
        public static void main(String[] args) {
            ListNode head = new ListNode(-1);
            ListNode h1 = new ListNode(1);
            ListNode h2 = new ListNode(2);
            ListNode h3 = new ListNode(2);
            head.next = h1;
            h1.next = h2;
            h2.next = h3;
            System.out.println(getNode(head, 1).val);
            System.out.println(elemCount(head, 2));
        }
    }

