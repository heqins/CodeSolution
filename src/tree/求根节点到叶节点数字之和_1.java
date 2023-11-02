package tree;

public class 求根节点到叶节点数字之和_1 {

    /**
     * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
     * 每条从根节点到叶节点的路径都代表一个数字：
     *
     * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
     * 计算从根节点到叶节点生成的 所有数字之和 。
     *
     * 叶节点 是指没有子节点的节点。
     */
    int result = 0;

    public int sumNumbers(TreeNode root) {
        helper(root, 0);

        return result;
    }

    public void helper(TreeNode root, int val) {
        if (root == null) {
            return;
        }

        // 利用了数字特性，从根节点到叶子节点的值=路径上一个节点*10+当前节点的值
        val = val * 10 + root.value;
        if (root.left == null && root.right == null) {
            result += val;
            return;
        }

        helper(root.left, val);
        helper(root.right, val);
    }
}
