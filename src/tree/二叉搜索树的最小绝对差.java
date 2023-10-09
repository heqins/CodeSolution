package tree;

public class 二叉搜索树的最小绝对差 {

    private TreeNode pre = null;

    private int min = Integer.MAX_VALUE;

    /**
     * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
     * 差值是一个正数，其数值等于两值之差的绝对值。
     * @param root
     * @return
     */
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
