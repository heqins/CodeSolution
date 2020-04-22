/**
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
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
 
 // 从底部层序遍历其实还是从顶部开始遍历，只不过最后存储的方式有所改变，可以参见我之前的博文 Binary Tree Level Order Traversal， 代码如下：

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;
        
        Stack<List<Integer>> stack = new Stack<List<Integer>>();
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while (!q.isEmpty()) {
            List<Integer> temp = new LinkedList<>();
            int size = q.size();
            
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
                temp.add(cur.val);
            }
            
            stack.add(temp);
        }
        
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        
        return res; 
    }
}
