package tree;

public class 二叉树的最小深度_1 {

    /**
     * 给定一个二叉树，找出其最小深度。
     *
     * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
     *
     * 说明：叶子节点是指没有子节点的节点。
     */
    private int min = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        helper(root, 1);

        return min;
    }

    public void helper(TreeNode root, int height) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            min = Math.min(min, height);
            return;
        }

        helper(root.left, height + 1);
        helper(root.right, height + 1);
    }
}
