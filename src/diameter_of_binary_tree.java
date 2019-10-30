/**
 先用的方法是只计算根节点的左右节点的高度，然后返回两个数相加的和，
 但是发现有些情况并没有通过，是因为可能最长路径并不是通过根节点的，
 例如左孩子只有一个节点，但是右孩子的左右节点都很多，
 所以最后的方法是在计算二叉树的高度的时候比较左右子节点的高度的和与当前最长路径比较，最后返回最长路径

 */

public class diameter_of_binary_tree {
    int maxNum;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null || (root.right == null && root.left == null)) {
            return 0;
        }
        helper(root);
        return maxNum;
    }
    private int helper(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);

        if (left + right > maxNum) {
            maxNum = left + right;
        }
        return left > right ? left + 1 : right + 1;
    }

    public static void main(String[] args) {
        diameter_of_binary_tree dbt = new diameter_of_binary_tree();
        TreeNode root = new TreeNode(3);
        TreeNode l1 = new TreeNode(4);
        TreeNode l2 = new TreeNode(2);
        TreeNode l3 = new TreeNode(5);
        TreeNode r1 = new TreeNode(5);
        TreeNode r2 = new TreeNode(6);
        root.left = l1;
        root.right = r1;
        l1.left = l2;
        l2.left = l3;
        l1.right = r2;
        System.out.println(dbt.diameterOfBinaryTree(root));
    }
}
