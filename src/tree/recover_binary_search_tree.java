/**
Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Example 1:

Input: [1,3,null,null,2]

   1
  /
 3
  \
   2

Output: [3,1,null,null,2]

   3
  /
 1
  \
   2
Example 2:

Input: [3,1,4,null,null,2]

  3
 / \
1   4
   /
  2

Output: [2,1,4,null,null,3]

  2
 / \
1   4
   /
  3
Follow up:

A solution using O(n) space is pretty straight forward.
Could you devise a constant space solution?
**/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**
这道题要求我们复原一个二叉搜索树，说是其中有两个的顺序被调换了，题目要求上说 O(n) 的解法很直观，这种解法需要用到递归，

用中序遍历树，并将所有节点存到一个一维向量中，把所有节点值存到另一个一维向量中，然后对存节点值的一维向量排序，

在将排好的数组按顺序赋给节点。这种最一般的解法可针对任意个数目的节点错乱的情况，这里先贴上此种解法：
**/

class Solution {
    public void recoverTree(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        List<Integer> vals = new ArrayList<>();
        
        inorder(root, list, vals);
        
        Collections.sort(vals);
        for (int i = 0; i < list.size(); i++) {
            list.get(i).val = vals.get(i);
        }
    }
    
    private void inorder(TreeNode root, List<TreeNode> list, List<Integer> vals) {
        if (root == null) return;
        
        inorder(root.left, list, vals);
        list.add(root);
        vals.add(root.val);
        inorder(root.right, list, vals);
    }
}
