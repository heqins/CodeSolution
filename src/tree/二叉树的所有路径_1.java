package tree;

import java.util.LinkedList;
import java.util.List;

public class 二叉树的所有路径_1 {

    /**
     * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
     *
     * 叶子节点 是指没有子节点的节点。
     */

    private LinkedList<String> res = new LinkedList();

    public List<String> binaryTreePaths(TreeNode root) {
        helper(root, "");

        return res;
    }

    public void helper(TreeNode root, String path) {
        // 进入节点后，判断是否叶子节点 。是的话，加入路径返回 ；不是的话，加入路径，继续遍历
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            res.add(path + String.valueOf(root.value));
            return;
        }

        path = path + root.value + "->";

        helper(root.left, path);

        helper(root.right, path);
    }
}
