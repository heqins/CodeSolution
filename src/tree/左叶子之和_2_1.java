package tree;

public class 左叶子之和_2_1 {

    /**
     * 给定二叉树的根节点 root ，返回所有左叶子之和。
     */
    public int sumOfLeftLeaves(TreeNode root) {
        int res = helper(root, false);
        return res;
    }

    public int helper(TreeNode root, boolean isLeft) {
        // 按照深度优先遍历的思路，整个过程可以分解成很多个重复的子过程。
        // 子过程 -> 当前遍历节点的左叶子节点总和=其左子树的左叶子节点数+其右子树的左叶子节点数。
        // 1.如果当前遍历的节点为叶子节点，1）该叶子节点为左节点，则返回其val值；2）该叶子节点为右节点，则返回0
        // 2.如果当前遍历的节点不为叶子节点，则返回其左子树的左叶子节点值+其右子树的左叶子节点值
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            if (isLeft) {
                return root.value;
            }

            return 0;
        }

        return helper(root.left, true) + helper(root.right, false);
    }
}
