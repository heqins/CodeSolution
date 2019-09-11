//    Definition for singly-linked list.
package DataStructure;

public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
      public String toString() {
            StringBuffer sb = new StringBuffer();
            sb.append("[");
            //拼接第一个元素
            sb.append(this.val);
            //获取当前节点的下一个节点
            ListNode node = this.next;
            while (node != null) {
                  sb.append("," + node.val);
                  node = node.next;
            }
            sb.append("]");
            return sb.toString();
      }
}
