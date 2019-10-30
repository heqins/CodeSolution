public class sum_of_left_leaves {
    public int sumOfLeftLeaves(TreeNode root) {
        int result;
        result = helper(root, "");
        return result;
    }

    public int helper(TreeNode root, String direction) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null && direction == "l") {
            return root.val;
        }

        int left = 0;
        int right = 0;
        if (root.left != null) {
            left = helper(root.left, "l");
        }
        if (root.right != null) {
            right = helper(root.right, "r");
        }
        return left + right;
    }
}
