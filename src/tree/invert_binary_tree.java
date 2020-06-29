/**
Invert a binary tree.

Example:

Input:

     4
   /   \
  2     7
 / \   / \
1   3 6   9
Output:

     4
   /   \
  7     2
 / \   / \
9   6 3   1
Trivia:
This problem was inspired by this original tweet by Max Howell:

Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so f*** off.
**/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

/**
Q： 为何需要暂存 rootrootroot 的左子节点？
A： 在递归右子节点 “root.left=mirrorTree(root.right);root.left = mirrorTree(root.right);root.left=mirrorTree(root.right);” 执行完毕后， root.leftroot.leftroot.left 的值已经发生改变，此时递归左子节点 mirrorTree(root.left)mirrorTree(root.left)mirrorTree(root.left) 则会出问题。

复杂度分析：

    时间复杂度 O(N)O(N)O(N) ： 其中 NNN 为二叉树的节点数量，建立二叉树镜像需要遍历树的所有节点，占用 O(N)O(N)O(N) 时间。
    空间复杂度 O(N)O(N)O(N) ： 最差情况下（当二叉树退化为链表），递归时系统需使用 O(N)O(N)O(N) 大小的栈空间。
**/
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        
        return root;
    }
}
