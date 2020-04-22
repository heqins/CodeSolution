/**
Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its depth = 3.
**/


import java.util.LinkedList;
import java.util.Queue;

public class maximum_depth_of_binary_tree {
    public int maxDepth(TreeNode root) {
        // DFS
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public int maxDepthBFS(TreeNode root) {
        if (root == null) return 0;

        int d = 0;
        Queue<TreeNode> frontier = new LinkedList<>();
        frontier.add(root);

        while (! frontier.isEmpty()) {

            d++;
            int fsize = frontier.size();
            // for循环-同一层节点
            for (int i=0; i<fsize; i++) {
                TreeNode cur = frontier.poll();

                if (cur.left != null) frontier.add(cur.left);
                if (cur.right != null) frontier.add(cur.right);
            }
        }

        return d;
    }

    public static void main(String[] args) {
        maximum_depth_of_binary_tree mdobt = new maximum_depth_of_binary_tree();
        TreeNode root = new TreeNode(-1);
        TreeNode l1 = new TreeNode(1);
        TreeNode l2 = new TreeNode(2);
        root.left = l1;
        l1.right = l2;

        System.out.println(mdobt.maxDepth(root));
    }
}
