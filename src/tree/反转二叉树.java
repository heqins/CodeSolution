package tree;

import java.util.Stack;

public class 反转二叉树 {


    /**
     * 遍历顺序：前中后  前序遍历 -> 中左右;中序遍历 -> 左中右;后序遍历 -> 左右中
     * 中序遍历不能用于反转二叉树
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        // 非递归形式 - 前序遍历
        if (root == null) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null) {stack.add(node.left);}
            if (node.right != null) {stack.add(node.right);}
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }

        return root;

        /** 递归形式 - 后序遍历
         * f (root == null) {
         *             return null;
         *         }
         *
         *         invertTree(root.left);
         *
         *         invertTree(root.right);
         *
         *         TreeNode tmp = root.left;
         *         root.left = root.right;
         *         root.right = tmp;
         *
         *         return root;
         */
    }


}
