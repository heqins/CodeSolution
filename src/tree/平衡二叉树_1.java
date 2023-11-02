package tree;

public class 平衡二叉树_1 {
    /**
     * 给定一个二叉树，判断它是否是高度平衡的二叉树。
     * 本题中，一棵高度平衡二叉树定义为：
     * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
     */

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (Math.abs(helper(root.left) - helper(root.right)) > 1) {
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }

    // 关键是要先写出求子树高度的辅助函数
    public int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = helper(root.left);
        int right = helper(root.right);

        return Math.max(left, right) + 1;
    }
}
