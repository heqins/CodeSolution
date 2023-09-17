package tree;

public class 二叉搜索树中的插入操作 {

    /**
     * 给定二叉搜索树（BST）的根节点 root 和要插入树中的值 value ，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 输入数据 保证 ，新值和原始二叉搜索树中的任意节点值都不同。
     *
     * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回 任意有效的结果 。
     * @param args
     */
    public static void main(String[] args) {

    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        // 迭代法 **在叶子节点的地方插入，不需要重构二叉搜索树**
        if (root == null) {
            return new TreeNode(val);
        }

        TreeNode newRoot = root;
        TreeNode pre = root;

        while (root != null) {
            pre = root;
            if (root.value > val) {
                root = root.left;
            }else if (root.value < val) {
                root = root.right;
            }
        }

        if (pre.value > val) {
            pre.left = new TreeNode(val);
        }else {
            pre.right = new TreeNode(val);
        }

        return newRoot;
    }
}
