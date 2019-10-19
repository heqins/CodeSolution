package DataStructure;

import java.util.LinkedList;

public class yingyong_04_03 {
    public static void levelOrderTraversal(TreeNode root) {
        if (root == null) return;
        LinkedList<TreeNode> list = new LinkedList<>();
        list.push(root);
        while (!list.isEmpty()) {
            TreeNode temp = list.poll();
            System.out.println(temp.val);
            if (temp.left != null) {
                list.add(temp.left);
            }
            if (temp.right != null) {
                list.add(temp.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-1);
        TreeNode l1 = new TreeNode(1);
        TreeNode l2 = new TreeNode(2);
        TreeNode l3 = new TreeNode(3);

        root.left = l1;
        root.right = l3;
        l1.right = l2;

        levelOrderTraversal(root);
    }
}
