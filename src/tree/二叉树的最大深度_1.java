package tree;

public class 二叉树的最大深度_1 {

    /**
     * 给定一个二叉树 root ，返回其最大深度。
     *
     * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
     * @param args
     */
    public static void main(String[] args) {

    }

    // 递归 - 后序遍历 -> 树的高度是左子树，右子树的最大高度 + 1
    // 空间和时间复杂度：O(N)
    public static int solve(TreeNode root) {
        if (root == null) {return 0;}

        return Math.max(solve(root.left), solve(root.right)) + 1;
    }

    // 非递归 - 层序遍历
    public static int maxHeight(TreeNode root) {
        return 0;
    }
}
