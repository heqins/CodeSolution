package tree;

public class 二叉树中的最大路径和 {

    /**
     * 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
     *
     * 路径和 是路径中各节点值的总和。
     *
     * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
     */
    int result = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        helper(root);

        return result;
    }

    public int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = helper(root.left);
        int right = helper(root.right);

        // 对于当前节点，路径最大和有4种情况：1、只有当前节点 2、当前节点+左节点 3、当前节点+右节点 4、当前节点+左节点+右节点
        // 递归返回值不能是第四种情况，只能是1，2，3中的一个，但是可以在递归的过程中记录这4个的最大值
        int sum = Math.max(root.value, Math.max(left, right) + root.value);
        result = Math.max(result, Math.max(sum, root.value + left + right));

        return sum;
    }
}
