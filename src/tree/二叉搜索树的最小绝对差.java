package tree;

public class 二叉搜索树的最小绝对差 {
    private TreeNode pre = null;

    private int min = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        travsal(root);

        return min;
    }

    public void travsal(TreeNode node) {
        if (node == null) {
            return;
        }

        travsal(node.left);

        if (pre != null) {
            min = Math.min(Math.abs(node.value - pre.value), min);
        }

        // 第一个节点不需要做相减
        // 回溯向上
        pre = node;

        travsal(node.right);
    }
}
