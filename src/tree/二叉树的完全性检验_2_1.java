package tree;

import java.util.LinkedList;
import java.util.Queue;

public class 二叉树的完全性检验_2_1 {

    /**
     * 给你一棵二叉树的根节点 root ，请你判断这棵树是否是一棵 完全二叉树 。
     *
     * 在一棵 完全二叉树 中，除了最后一层外，所有层都被完全填满，
     * 并且最后一层中的所有节点都尽可能靠左。最后一层（第 h 层）中可以包含 1 到 2h 个节点。
     */

    // 思路：把一颗树的节点（包括空节点）按层序遍历排成一行，
    // 当且仅当存在两个相邻节点：前一个为null，后一个不为null时，才不是完全二叉树。
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return false;
        }

        Queue<TreeNode> queue = new LinkedList();
        TreeNode pre = root;
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node != null && pre == null) {
                return false;
            }

            if (node != null) {
                // 空节点也要往队列里放
                queue.add(node.left);
                queue.add(node.right);
            }

            pre = node;
        }

        return true;
    }
}
