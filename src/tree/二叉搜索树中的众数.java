package tree;

import java.util.ArrayList;
import java.util.List;

public class 二叉搜索树中的众数 {

    /**
     * 给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。
     *
     * 如果树中有不止一个众数，可以按 任意顺序 返回。
     *
     * 假定 BST 满足如下定义：
     *
     * 结点左子树中所含节点的值 小于等于 当前节点的值
     * 结点右子树中所含节点的值 大于等于 当前节点的值
     * 左子树和右子树都是二叉搜索树
     */
    private int count = 0;

    private int maxCount = 0;

    private TreeNode pre = null;

    private List<Integer> result = new ArrayList();

    public int[] findMode(TreeNode root) {
        travsal(root);

        int[] res = result.stream()
                .mapToInt(Integer::intValue)
                .toArray();

        return res;
    }

    public void travsal(TreeNode root) {
        if (root == null) {
            return;
        }

        travsal(root.left);

        // 如何只用常数级别空间和1次遍历
        // 当pre不等于当前值时，重置计数，当count>最大计数时，将当前值添加到结果集，更新maxCount

        if (pre == null) {
            count = 1;
        }else if (pre.value == root.value) {
            count++;
        }else {
            count = 1;
        }

        pre = root;
        if (count == maxCount) {
            result.add(root.value);
        }

        if (count > maxCount) {
            result.clear();
            maxCount = count;
            result.add(root.value);
        }

        travsal(root.right);
    }
}
