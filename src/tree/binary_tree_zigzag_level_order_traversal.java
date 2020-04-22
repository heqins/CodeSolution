/**
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
**/

/**
这道二叉树的之字形层序遍历是之前那道 Binary Tree Level Order Traversal 的变形，不同之处在于一行是从左到右遍历，

下一行是从右往左遍历，交叉往返的之字形的层序遍历。最简单直接的方法就是利用层序遍历，并使用一个变量 cnt 来统计当前的层数（从0开始），

将所有的奇数层的结点值进行翻转一下即可，参见代码如下：

**/

import java.util.*;

public class binary_tree_zigzag_level_order_traversal {
    private Stack<TreeNode> leftStack = new Stack();
    private Stack<TreeNode> rightStack = new Stack();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        leftStack.push(root);

        List<List<Integer>> returnList = new ArrayList();
        if(root == null) {
            return returnList;
        }

        List<Integer> fList = new ArrayList();
        fList.add(root.val);
        returnList.add(fList);

        while(!leftStack.isEmpty() || !rightStack.isEmpty()) {

            List<Integer> lList = new ArrayList();
            while(!leftStack.isEmpty()) {
                TreeNode lNode = leftStack.pop();


                if(lNode.right != null) {
                    rightStack.push(lNode.right);
                    lList.add(lNode.right.val);
                }

                if(lNode.left != null) {
                    rightStack.push(lNode.left);
                    lList.add(lNode.left.val);
                }
            }

            if(!lList.isEmpty()) {
                returnList.add(lList);
            }

            List<Integer> rList = new ArrayList();
            while(!rightStack.isEmpty()) {
                TreeNode rNode = rightStack.pop();


                if(rNode.left != null) {
                    leftStack.push(rNode.left);
                    rList.add(rNode.left.val);
                }

                if(rNode.right != null) {
                    leftStack.push(rNode.right);
                    rList.add(rNode.right.val);
                }
            }

            if(!rList.isEmpty()) {
                returnList.add(rList);
            }
        }

        return returnList;
    }
}

