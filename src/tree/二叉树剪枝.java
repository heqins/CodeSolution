package tree;

public class 二叉树剪枝 {

    public static void main(String[] args) {

    }

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
