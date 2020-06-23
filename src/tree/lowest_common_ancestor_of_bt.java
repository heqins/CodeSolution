/**
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]


 

Example 1:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.
Example 2:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
**/

/**
考虑通过递归对二叉树进行后序遍历，当遇到节点 ppp 或 qqq 时返回。从底至顶回溯，当节点 p,qp, qp,q 在节点 rootrootroot 的异侧时，节点 rootrootroot 即为最近公共祖先，则向上返回 rootrootroot 。
递归解析：

    终止条件：
        当越过叶节点，则直接返回 nullnullnull ；
        当 rootrootroot 等于 p,qp, qp,q ，则直接返回 rootrootroot ；
    递推工作：
        开启递归左子节点，返回值记为 leftleftleft ；
        开启递归右子节点，返回值记为 rightrightright ；
    返回值： 根据 leftleftleft 和 rightrightright ，可展开为四种情况；
        当 leftleftleft 和 rightrightright 同时为空 ：说明 rootrootroot 的左 / 右子树中都不包含 p,qp,qp,q ，返回 nullnullnull ；
        当 leftleftleft 和 rightrightright 同时不为空 ：说明 p,qp, qp,q 分列在 rootrootroot 的 异侧 （分别在 左 / 右子树），因此 rootrootroot 为最近公共祖先，返回 rootrootroot ；
        当 leftleftleft 为空 ，rightrightright 不为空 ：p,qp,qp,q 都不在 rootrootroot 的左子树中，直接返回 rightrightright 。具体可分为两种情况：
            p,qp,qp,q 其中一个在 rootrootroot 的 右子树 中，此时 rightrightright 指向 ppp（假设为 ppp ）；
            p,qp,qp,q 两节点都在 rootrootroot 的 右子树 中，此时的 rightrightright 指向 最近公共祖先节点 ；

作者：jyd
链接：https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/solution/mian-shi-ti-68-ii-er-cha-shu-de-zui-jin-gong-gon-7/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
**/

public class lowest_common_ancestor_of_bt {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if( root == p || root == q || root == null)
            return root;
        TreeNode left = lowestCommonAncestor( root.left,  p,  q);
        TreeNode right = lowestCommonAncestor( root.right,  p,  q);
        if(left == null)
            return right;
        else if (right == null)
            return left;
        else
            return root;
    }
}
