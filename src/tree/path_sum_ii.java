/**
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1
Return:

[
   [5,4,11,2],
   [5,8,4,5]
]
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
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        if(root==null) return res;

        Stack<Integer> temp = new Stack<Integer>();
        
        pathSumInner(root, sum, res, temp);
        
        return res;
    }
    
    private void pathSumInner(TreeNode root, int sum, List<List<Integer>> resultList, Stack<Integer> path) {
        path.push(root.val);
        if(root.left == null && root.right == null)
            if(sum == root.val) resultList.add(new ArrayList<Integer>(path));
        if(root.left!=null) pathSumInner(root.left, sum-root.val, resultList, path);
        if(root.right!=null)pathSumInner(root.right, sum-root.val, resultList, path);
        path.pop();
    }
}
