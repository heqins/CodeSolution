package DataStructure;

public class yingyong_04_04 {
    public static int getDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-1);
        TreeNode l1 = new TreeNode(1);
        TreeNode l2 = new TreeNode(2);
        root.left = l1;
        l1.right = l2;

        System.out.println(getDepth(root));
    }
}
