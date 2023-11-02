package tree;

public class 二叉树的最近公共祖先_1 {

    /**
     *
     * @param args
     */
    // 如果从下往上去处理？后序遍历
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        // 如果p或q本身是公共祖先？包含这种情况，直接返回了
        if (root.value == p.value || root.value == q.value) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        if (left == null && right != null) {
            return right;
        }

        if (right == null && left != null) {
            return left;
        }

        return null;
    }
}
