package DataStructure;

public class yingyong_01_03 {
        public static ListNode reverse(ListNode head) {
            ListNode prev = null;
            ListNode cur = head;
            while(cur!=null){
                ListNode temp = cur.next;
                cur.next = prev;
                prev = cur;
                cur = temp;
            }

            head = prev;
            return head;
        }

        public static void reverse(SequenceList seqList) {
            int mid = seqList.len / 2;
            for (int i = 0; i < mid; i++) {
                int temp = (int)seqList.table[i];
                seqList.table[i] = (int)seqList.table[seqList.len - i - 1];
                seqList.table[seqList.len - i - 1] = temp;
            }
        }

        public static void main(String[] args) {
            ListNode head = new ListNode(0);
            ListNode h1 = new ListNode(1);
            ListNode h2 = new ListNode(2);
            ListNode h3 = new ListNode(3);
            head.next = h1;
            h1.next = h2;
            h2.next = h3;
            ListNode newHead = reverse(head);
            System.out.println(newHead.val);

            SequenceList seqList = new SequenceList(999);
            seqList.add(1);
            seqList.add(1);
            seqList.add(3);
            seqList.add(4);
            seqList.add(6);
            reverse(seqList);
            System.out.println(seqList.table[0]);
        }
    }
