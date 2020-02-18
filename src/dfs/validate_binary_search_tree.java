public class validate_binary_search_tree {
    TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
        // 中序遍历
        if(root == null) return true; // If the root is null it's a BST

        if(!isValidBST(root.left)) return false;
        if(prev != null && prev.val >= root.val) return false;
        prev = root;
        if(!isValidBST(root.right)) return false;


        return true;
    }

    public boolean isValidBST2(TreeNode root) {
        // 利用自身性质,传入上下限
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.val >= maxVal || root.val <= minVal) return false;
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }
}
