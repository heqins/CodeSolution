public class kth_smallest_element_of_bst {
    private static int count = 0;
    private static int number = 0;

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        helper(root);
        return number;
    }

    public void helper(TreeNode root) {
        if (root.left != null) helper(root.left);
        count--;
        if (count == 0) {
            number = root.val;
        }
        if (root.right != null) helper(root.right);
    }

    /**
     * Binary Search:
     * public int kthSmallest(TreeNode root, int k) {
     *       int count = countNodes(root.left);
     *       if (k <= count) {
     *           return kthSmallest(root.left, k);
     *       } else if (k > count + 1) {
     *           return kthSmallest(root.right, k-1-count); // 1 is counted as current node
     *       }
     *
     *       return root.val;
     *   }
     *
     *   public int countNodes(TreeNode n) {
     *       if (n == null) return 0;
     *
     *       return 1 + countNodes(n.left) + countNodes(n.right);
     *   }
     */
}
