package tree;

public class 删除二叉搜索树中的节点 {

    /**
     * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
     * 一般来说，删除节点可分为两个步骤：
     * 首先找到需要删除的节点；
     * 如果找到了，删除它。
     */

    // 不存在要删除的节点
    // 左为空，右不为空
    // 左不为空，右为空
    // 左右都不为空
    // 叶子节点
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.value == key) {
            // 若左/右子树为空，我们直接返回右/左子树节点即可（含义为直接将右/左子树节点搬到当前节点的位置）
            if (root.left == null) {
                return root.right;
            }

            if (root.right == null) {
                return root.left;
            }

            // 我们以「从当前节点的左子树中选择值最大的节点」为例子，我们通过树的遍历，
            // 找到其位于「最右边」的节点，记为 ttt（ttt 作为最右节点，必然有 t.right = null），
            // 利用原本的 root 也是合法 BST，原本的 root.right 子树的所有及节点，必然满足大于 t.val，
            // 我们可以直接将 root.right 接在 t.right 上，并返回我们重接后的根节点，也就是 root.left。

            TreeNode t = root.left;
            while (t.right != null) {
                t = t.right;
            }

            t.right = root.right;

            return root.left;
        }else if (root.value < key) {
            root.right = deleteNode(root.right, key);
        }else {
            root.left = deleteNode(root.left, key);
        }

        return root;
    }
}
