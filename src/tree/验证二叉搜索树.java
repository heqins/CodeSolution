package tree;

import java.util.ArrayList;
import java.util.List;

public class 验证二叉搜索树 {

    /**
     * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
     *
     * 有效 二叉搜索树定义如下：
     *
     * 节点的左子树只包含 小于 当前节点的数。
     * 节点的右子树只包含 大于 当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树。
     */

    public boolean isValidBST(TreeNode root) {
        // 空的树也是二叉搜索树
        List<Integer> nums  = new ArrayList();

        helper(root, nums);

        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i) >= nums.get(i + 1)) {
                return false;
            }
        }

        return true;
    }

    public void helper(TreeNode node, List<Integer> nums) {
        if (node == null) {
            return;
        }

        helper(node.left, nums);

        nums.add(node.value);

        helper(node.right, nums);
    }
}
