package tree;

import java.util.LinkedList;

public class 填充每个节点的下一个右侧节点指针 {

    /**
     * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
     *
     * struct Node {
     *   int val;
     *   Node *left;
     *   Node *right;
     *   Node *next;
     * }
     * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
     *
     * 初始状态下，所有 next 指针都被设置为 NULL。
     */
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            Node pre = null;

            for (int i = 0; i < size; i++) {
                Node node = queue.poll();

                if (pre != null) {
                    node.next = pre;
                }

                pre = node;

                if (node.right != null) {
                    queue.offer(node.right);
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }
            }

        }

        return root;
    }
}
