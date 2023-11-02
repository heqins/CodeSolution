package tree;

public class 二叉树的直径_1 {

    /**
     * 给你一棵二叉树的根节点，返回该树的 直径 。
     * 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。
     * 两节点之间路径的 长度 由它们之间边数表示。
     */
    private int max = Integer.MIN_VALUE;

    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);

        return max;
    }

    public int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = helper(root.left);
        int right = helper(root.right);

        // 将路径转换为高度
        max = Math.max(max, left + right);

        return Math.max(left, right) + 1;
    }
}
