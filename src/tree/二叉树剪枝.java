package tree;

public class 二叉树剪枝 {

    /**
     * 给你二叉树的根结点 root ，此外树的每个结点的值要么是 0 ，要么是 1 。
     * 返回移除了所有不包含 1 的子树的原二叉树。
     * 节点 node 的子树为 node 本身加上所有 node 的后代。
     * @param root
     * @return
     */
    public static TreeNode pruneTree(TreeNode root) {
        if (isAllZero(root)) return null;

        return root;
    }

    public static boolean isAllZero(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean left = isAllZero(root.left);
        boolean right = isAllZero(root.right);

        if (left) {
            root.left = null;
        }

        if (right) {
            root.right = null;
        }

        // 是否当前节点为0，且左右节点全为0
        return root.value == 0 && left && right;
    }
}
