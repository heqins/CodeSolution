package DataStructure;

import java.util.LinkedList;

public class yingyong_04_06 {
    public static boolean isCompleteBTS(TreeNode root) {
        if (root == null) return false;
        boolean flag = false;
        LinkedList<TreeNode> q = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null && cur.right != null) {
                return false;
            }
            if (flag && cur.left != null) {
                return false;
            }
            if (cur.left == null || cur.right == null) {
                flag = true;
            }
            if (cur.left != null) {
                q.push(cur.left);
            }

            if (cur.right != null) {
                q.push(cur.right);
            }
            q.pop();
            if(!q.isEmpty()) {
                cur = q.pop();
            }else {
                cur = null;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-1);
        TreeNode l1 = new TreeNode(1);
        TreeNode l2 = new TreeNode(2);
        TreeNode l3 = new TreeNode(3);

        root.left = l1;
        root.right = l3;
        l1.left = l2;

        System.out.println(isCompleteBTS(root));
    }
}
