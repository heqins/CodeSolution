package DataStructure;

public class yingyong_04_05 {
    public static int sumLeaf(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return sumLeaf(root.left) + sumLeaf(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-1);
        TreeNode l1 = new TreeNode(1);
        TreeNode l2 = new TreeNode(2);
        TreeNode l3 = new TreeNode(2);

        root.left = l1;
        root.right = l3;
        l1.right = l2;

        System.out.println(sumLeaf(root));
    }
}
