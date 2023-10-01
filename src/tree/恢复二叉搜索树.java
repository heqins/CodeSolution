package tree;

public class 恢复二叉搜索树 {
    /**
     * 给你二叉搜索树的根节点 root ，该树中的 恰好 两个节点的值被错误地交换。请在不改变其结构的情况下，恢复这棵树 。
     */
    //用两个变量x，y来记录需要交换的节点
    private TreeNode left = null;
    private TreeNode right = null;
    private TreeNode pre = null;

    public void recoverTree(TreeNode root) {
        helper(root);

        if (left != null && right != null) {
            int val = right.value;
            right.value = left.value;
            left.value = val;
        }
    }

    public void helper(TreeNode root) {
        if (root == null) {
            return;
        }

        helper(root.left);

        if (pre != null && root.value < pre.value) {
            if (left == null) {
                left = pre;
            }

            right = root;
        }

        pre = root;

        helper(root.right);
    }

    /**
     * 方法二中我们不再显示的用数组存储中序遍历的值序列，但是我们会发现我们仍需要 O(H)的栈空间，
     * 无法满足题目的进阶要求，那么该怎么办呢？这里向大家介绍一种不同于平常递归或迭代的遍历二叉树的方法：
     * Morris 遍历算法，该算法能将非递归的中序遍历空间复杂度降为 O(1)。
     */
}
