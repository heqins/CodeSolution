package tree;

public class 从前序与中序遍历序列构造二叉树 {

    /**
     * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历，
     * inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
     * 示例 1:
     *
     *
     * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
     * 输出: [3,9,20,null,null,15,7]
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preStartIndex = 0;
        int preEndIndex = preorder.length - 1;

        int inStartIndex = 0;
        int inEndindex = inorder.length - 1;

        TreeNode root = buildTreeHelper(preorder, preStartIndex, preEndIndex, inorder, inStartIndex, inEndindex);

        return root;
    }

    public TreeNode buildTreeHelper(int[] preorder, int preStartIndex, int preEndIndex, int[] inorder, int inStartIndex, int inEndIndex) {
        if (preStartIndex > preEndIndex || inStartIndex > inEndIndex) {
            return null;
        }

        int preRoot = preorder[preStartIndex];
        int inRootIndex = -1;

        for (int i = inStartIndex; i <= inEndIndex; i++) {
            if (inorder[i] == preRoot) {
                inRootIndex = i;
                break;
            }
        }

        if (inRootIndex == -1) {
            return null;
        }

        TreeNode root = new TreeNode(preRoot);

        int sub = inRootIndex - inStartIndex;

        TreeNode left = buildTreeHelper(preorder, preStartIndex + 1, preStartIndex + sub,
                inorder, inStartIndex, inRootIndex - 1);

        TreeNode right = buildTreeHelper(preorder, preStartIndex + sub + 1, preEndIndex,
                inorder, inStartIndex + sub + 1, inEndIndex);

        root.left = left;
        root.right = right;

        return root;
    }
}
