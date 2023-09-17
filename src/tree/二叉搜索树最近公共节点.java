package tree;

public class 二叉搜索树最近公共节点 {

    /**
     * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
     * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
     * @param args
     */
    public static void main(String[] args) {

    }

    // 利用二叉搜索树的特性，最近公共祖先必然大于p或q中的一个，小于p或q的一个

    /**
     * 它的时间复杂度是 O(h)，其中 h 是二叉树的高度，因为在二叉搜索树中，
     * 查找节点的时间复杂度与树的高度相关。在平衡的二叉搜索树中，h 可以近似看作 O(log n)，其中 n 是树中节点的总数
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.value < p.value && root.value < q.value) {
                root = root.right;
            }else if (root.value > p.value && root.value > q.value) {
                root = root.left;
            }else {
                break;
            }
        }

        return root;
    }
}
