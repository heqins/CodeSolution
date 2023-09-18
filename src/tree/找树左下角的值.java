package tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class 找树左下角的值 {
    /**
     * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
     *
     * 假设二叉树中至少有一个节点。
     */

    /**
     * 时间复杂度：O(n)，其中 n为二叉树的节点个数。
     * 空间复杂度：O(n)。
     * @param root
     * @return
     */
    public int findBottomLeftValue(TreeNode root) {
        TreeNode node = root;
        Queue<TreeNode> q = new ArrayDeque<>();

        q.add(root);

        // 层序遍历，从右向左，最后的那个就是最左边的
        while (!q.isEmpty()) {
            node = q.poll();

            if (node.right != null) {
                q.add(node.right);
            }

            if (node.left != null) {
                q.add(node.left);
            }
        }

        return node.value;
    }
}
