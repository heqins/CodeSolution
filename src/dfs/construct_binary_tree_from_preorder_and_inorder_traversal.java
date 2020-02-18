public class construct_binary_tree_from_preorder_and_inorder_traversal {
    /**
     * 对于给定的前序遍历preorder和中序遍历inorder，首先我们不难发现，这棵树的根结点其实就是preorder[0]。
     * 由于preorder和inorder是对同一棵树的遍历，我们可以知道preorder[0]在inorder中一定也存在，不妨设preorder[0]==inorder[k]。
     *
     * 由于inorder是中序遍历，所以k左边的就是根节点左子树的中序遍历、k右边的就是根节点右子树的中序遍历。
     *
     * 并且，由于我们已经知道了根节点左子树的节点数（与中序遍历长度相同），不妨设为l，我们可以知道preorder从1到l+1就是根节点左子树的前序遍历，
     * 剩下的最后一部分就是根节点右子树的前序遍历。
     *
     * 也就是说，我们可以计算出左子树、右子树的前序遍历和中序遍历，从而可以用分治的思想，将规模较大的问题分解成为两个较小的问题，然后递归的进行处理，
     * 还原左子树和右子树，最后连通根节点一起组成一棵完整的树。
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return work(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode work(int[] preorder, int[] inorder, int lp, int rp, int li, int ri) {
        // 判断长度为0的情况
        if (lp > rp) return null;

        // 设置根结点
        TreeNode root = new TreeNode(preorder[lp]);
        // 找到根结点在inorder中的位置
        for (int k = li; k <= ri; k++) {
            if (preorder[lp] == inorder[k]) {
                root.left = work(preorder, inorder, lp + 1, lp + (k - li), li, k - 1);
                root.right = work(preorder, inorder, lp + (k - li) + 1, rp, k + 1, ri);
            }
        }
        return root;
    }
}
