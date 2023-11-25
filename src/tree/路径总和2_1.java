package tree;

import java.util.LinkedList;
import java.util.List;

public class 路径总和2_1 {

    /**
     * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
     * 叶子节点 是指没有子节点的节点。
     */

    /**
     * 时间复杂度 O(N)： N 为二叉树的节点数，先序遍历需要遍历所有节点。
     * 空间复杂度 O(N) ： 最差情况下，即树退化为链表时，path 存储所有树节点，使用 O(N)额外空间。
     */
    LinkedList<List<Integer>> res = new LinkedList<>();

    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        helper(root, targetSum);

        return res;
    }

    public void helper(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }

        path.add(root.value);
        targetSum -= root.value;

        if (targetSum == 0 && root.left == null && root.right == null) {
            res.add(new LinkedList<>(path));
        }

        helper(root.left, targetSum);
        helper(root.right, targetSum);

        path.removeLast();
    }
}
