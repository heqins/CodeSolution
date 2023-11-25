package tree;

public class 二叉搜索树中的搜索_1 {

    /**
     * 给定二叉搜索树（BST）的根节点 root 和一个整数值 val。
     * 你需要在 BST 中找到节点值等于 val 的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 null 。
     */

    public TreeNode searchBST(TreeNode root, int val) {

        TreeNode node = find(root, val);

        return node;
    }

    // 利用二叉搜索树的特性进行搜索查找
    public TreeNode find(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (root.value == val) {
            return root;
        }

        if (root.value > val) {
            return find(root.left, val);
        }

        return find(root.right, val);
    }
}
