package tree;

import java.util.LinkedList;

public class 对称二叉树_2_1 {

    /**
     * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
     * @param args
     */
    public static void main(String[] args) {

    }

    public static boolean solve(TreeNode root) {
        // 比较左子节点的左孩子和右子节点的右孩子是否相等；左子节点的右孩子和右子节点的左孩子是否相等
        // 非递归形式
        if(root == null || (root.left == null && root.right == null)) {
            return true;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        while (queue.size() > 0) {
            TreeNode left = queue.removeFirst();
            TreeNode right = queue.removeFirst();

            if (left != null && right == null) {
                return false;
            }

            if (left == null && right != null) {
                return false;
            }

            if (left == null && right == null) {
                continue;
            }

            if (left.value.intValue() != right.value) {
                return false;
            }

            queue.add(left.left);
            queue.add(right.right);

            queue.add(left.right);
            queue.add(right.left);
        }

        return true;
    }

    public boolean isSymmetric(TreeNode root) {
        return helper(root.left, root.right);
    }

    public boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null && right != null) {
            return false;
        }

        if (right == null && left != null) {
            return false;
        }

        if (left.value != right.value) {
            return false;
        }

        return helper(left.left, right.right) && helper(left.right, right.left);
    }
}
