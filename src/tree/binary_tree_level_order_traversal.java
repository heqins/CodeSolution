/**
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
**/
/**
层序遍历二叉树是典型的广度优先搜索 BFS 的应用，但是这里稍微复杂一点的是，要把各个层的数分开，存到一个二维向量里面，

大体思路还是基本相同的，建立一个 queue，然后先把根节点放进去，这时候找根节点的左右两个子节点，这时候去掉根节点，

此时 queue 里的元素就是下一层的所有节点，用一个 for 循环遍历它们，然后存到一个一维向量里，遍历完之后再把这个一维向量存到二维向量里，

以此类推，可以完成层序遍历，参见代码如下：

**/

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class binary_tree_level_order_traversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if (root == null) return res;

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

            res.add(temp);
        }

        return res;
    }

    public static void main(String[] args) {

    }
}
