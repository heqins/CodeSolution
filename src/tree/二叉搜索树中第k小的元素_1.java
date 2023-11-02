package tree;

public class 二叉搜索树中第k小的元素_1 {

    /**
     * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
     */
    private int result = 0;

    private int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        helper(root, k);

        return result;
    }

    public void helper(TreeNode root, int k) {
        if (root == null) {
            return;
        }


        helper(root.left, k);

        count++;

        if (count > k) {
            return;
        }

        if (count == k) {
            result = root.value;
            return;
        }

        helper(root.right, k);
    }
}
