package tree;

public class 将二叉搜索树转化为排序的双向链表_2 {

    /**
     * 将一个 二叉搜索树 就地转化为一个 已排序的双向循环链表 。
     *
     * 对于双向循环列表，你可以将左右孩子指针作为双向循环链表的前驱和后继指针，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。
     *
     * 特别地，我们希望可以 就地 完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中最小元素的指针。
     */
    private Node pre = null;
    private Node head = null;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return root;
        }

        helper(root);

        head.left = pre;

        pre.right = head;

        return head;
    }

    public void helper(Node root) {
        if (root == null) {
            return;
        }

        helper(root.left);

        // 采用中序遍历，遍历途中更新两个指针
        if (pre != null) {
            pre.right = root;
        }else {
            // 如果在最左边,pre=null，这个时候的节点就是双向链表的头
            head = root;
        }

        root.left = pre;

        pre = root;

        helper(root.right);
    }
}
