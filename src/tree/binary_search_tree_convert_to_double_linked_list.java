/**
输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。

*********************************************************************************************************

首先我们一定要想到用中序遍历二叉树。

    关键：设置一个末尾节点指针用来串联根节点的两侧连接
    先将左子树遍历完，然后末尾节点指针将指向左子树的最右侧,然后根节点的左指针就指向了末尾节点
    当右子树的最左侧遍历完之后，右子树的最左侧的节点的左指针就将指向根节点（此时的末尾节点）
**/


/**
 * 二叉搜索树与双向链表
 *
 * @Author rex
 * 2018/8/11
 */
public class Solution {
    /**
     * 关键
     */
    private BinaryTreeNode lastNode;

    /**
     * 参考解题
     * @param pRootOfTree
     * @return
     */
    public BinaryTreeNode convert(BinaryTreeNode pRootOfTree) {

        convertChild(pRootOfTree);
        BinaryTreeNode firstNode = lastNode;
        while (lastNode != null && firstNode.left !=null) {
            firstNode = firstNode.left;
        }
        return firstNode;

    }

    public void convertChild(BinaryTreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return;
        }
        BinaryTreeNode current = pRootOfTree;
        if (current.left != null) {
            convertChild(current.left);
        }
        // 关键
        current.left = lastNode;
        if (lastNode != null) {
            // 关键
            lastNode.right = current;
        }
        lastNode = current;
        if (current.right != null) {
            convertChild(current.right);
        }
    }

}
