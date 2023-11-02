package tree;

public class 把二叉搜索树转换为累加树_1 {

    /**
     * 给定一个二叉搜索树，请将它的每个节点的值替换成树中大于或者等于该节点值的所有节点值之和。
     *
     * 提醒一下，二叉搜索树满足下列约束条件：
     *
     * 节点的左子树仅包含键 小于 节点键的节点。
     * 节点的右子树仅包含键 大于 节点键的节点。
     * 左右子树也必须是二叉搜索树。
     * @param args
     */
    private static int pre = 0;

    public static TreeNode convertBST(TreeNode root) {
        travsal(root);

        return root;
    }

    /**
     * 按照右中左的顺序遍历，定义pre指针，指向前一个节点的值（当前累加到的）
     * @param root
     */
    public static void travsal(TreeNode root) {
        if (root == null) {
            return;
        }

        travsal(root.right);

        pre += root.value;
        root.value = pre;

        travsal(root.left);
    }
}
