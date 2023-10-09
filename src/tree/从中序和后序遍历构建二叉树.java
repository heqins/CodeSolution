package tree;

public class 从中序和后序遍历构建二叉树 {

    /**
     * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历，
     * postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
     */

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int inStartIndex = 0;
        int inEndIndex = inorder.length - 1;

        int postStartIndex = 0;
        int postEndIndex = postorder.length - 1;

        TreeNode root = buildTreeHelper(inorder, inStartIndex, inEndIndex, postorder, postStartIndex, postEndIndex);

        return root;
    }

    public TreeNode buildTreeHelper(int[] inorder, int inStartIndex, int inEndIndex, int[] postorder, int postStartIndex, int postEndIndex) {
        if (inStartIndex > inEndIndex || postStartIndex > postEndIndex) {
            return null;
        }

        int rootValue = postorder[postEndIndex];
        TreeNode root = new TreeNode(rootValue);

        int inRootIndex = 0;
        for (int i = inStartIndex; i <= inEndIndex; i++) {
            if (inorder[i] == rootValue) {
                inRootIndex = i;
                break;
            }
        }

        int leftSubTreeSize = inRootIndex - inStartIndex;

        root.left = buildTreeHelper(inorder, inStartIndex, inRootIndex - 1, postorder, postStartIndex, postStartIndex + leftSubTreeSize - 1);

        root.right = buildTreeHelper(inorder, inRootIndex + 1, inEndIndex, postorder, postStartIndex + leftSubTreeSize, postEndIndex - 1);

        return root;
    }
}
