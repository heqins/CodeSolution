package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 二叉树的后序遍历 {
    /**
     * 给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
     */

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList();
        }

        Stack<TreeNode> stack = new Stack();
        List<Integer> result = new ArrayList();
        TreeNode last = null;

        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                // 看下父节点的右子树是否为空
                TreeNode temp = stack.peek();
                if (temp.right != null && temp.right != last) {
                    root = temp.right;
                }else {
                    result.add(temp.value);
                    last = temp;
                    stack.pop();
                }
            }
        }

        return result;
    }
}
