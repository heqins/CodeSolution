public class rangesumBST {
    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    int sum = 0;

    public int rangeSumBST(TreeNode root, int L, int R) {
        if(root.left.val >= L && root.right.val <= R) {
            sum += root.val;
        }

        return rangeSumBST(root.left, L, R);
//        return rangeSumBST(root.right, L, R);
    }
}
