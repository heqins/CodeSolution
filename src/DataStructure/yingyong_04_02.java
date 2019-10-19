package DataStructure;

import java.util.Stack;

public class yingyong_04_02 {
    public static void PreOrderTraversal(TreeNode root) {
        if (root == null) return;
        System.out.println(root.val);
        PreOrderTraversal(root.left);
        PreOrderTraversal(root.right);
    }

    public static void InOrderTraversal(TreeNode root) {
        if (root == null) return;
        InOrderTraversal(root.left);
        System.out.println(root.val);
        InOrderTraversal(root.right);
    }

    public static void PostOrderTraversal(TreeNode root) {
        if (root == null) return;
        PostOrderTraversal(root.left);
        PostOrderTraversal(root.right);
        System.out.println(root.val);
    }

    public static void PreOrderTraversal2(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> s = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !s.isEmpty()) {
            while (cur != null) {
                System.out.println(cur.val);
                s.push(cur);
                cur = cur.left;
            }
            cur = s.pop();
            cur = cur.right;
        }
    }

    public static void InOrderTraversal2(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> s = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !s.isEmpty()) {
            while (cur != null) {
                s.push(cur);
                cur = cur.left;
            }
            cur = s.pop();
            System.out.println(cur.val);
            cur = cur.right;
        }
    }

    public static void PostOrderTraversal2(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> s = new Stack<>();
        TreeNode cur = root;
        TreeNode lastVisit = null;

        while (cur != null) {
            s.push(cur);
            cur = cur.left;
        }

        while (!s.isEmpty()) {
            cur = s.pop();
            if (cur.right != null && cur.right != lastVisit) {
                s.push(cur);
                cur = cur.right;
                while (cur != null) {
                    s.push(cur);
                    cur = cur.left;
                }
            }else {
                System.out.println(cur.val);
                lastVisit = cur;
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

        PostOrderTraversal(root);
        System.out.println("------------------");
        PostOrderTraversal2(root);
    }
}
