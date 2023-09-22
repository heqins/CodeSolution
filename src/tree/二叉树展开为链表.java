package tree;

public class 二叉树展开为链表 {

    /**
     * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
     *
     * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
     * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
     */
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten(root.left);
        flatten(root.right);

        // 分为三步：1、构建左子树的链表 2、构建右子树的链表 3、将左子树的链表的右边只想右子树的链表
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = null;

        while (root.right != null) {
            root = root.right;
        }

        root.right = temp;
    }
}
