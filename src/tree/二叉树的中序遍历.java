package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 二叉树的中序遍历 {

    /**
     * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        List<Integer> result = new ArrayList();

        // 向下和向上的判断条件
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }

            TreeNode temp = stack.pop();
            result.add(temp.value);

            if (temp.right != null) {
                root = temp.right;
            }
        }

        return result;
    }
}
