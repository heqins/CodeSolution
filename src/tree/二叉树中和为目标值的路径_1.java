package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 二叉树中和为目标值的路径_1 {

    /**
     * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
     * 叶子节点是指没有子节点的节点。
     */
    public List<List<Integer>> pathTarget(TreeNode root, int target) {
        List<List<Integer>> result = new ArrayList();

        helper(result, new LinkedList(), root, target);

        return result;
    }

    public void helper(List<List<Integer>> result, List<Integer> temp, TreeNode root, int target) {
        if (root == null) {
            return;
        }

        temp.add(root.value);
        target -= root.value;

        if (target == 0 && root.left == null && root.right == null) {
            result.add(new ArrayList(temp));
            // 不能return
            // 如果在这里return会影响回溯删除路径中的当前节点
        }

        helper(result, temp, root.left, target);
        helper(result, temp, root.right, target);

        temp.remove(temp.size() - 1);
    }
}
