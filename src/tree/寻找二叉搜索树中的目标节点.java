package tree;

public class 寻找二叉搜索树中的目标节点 {

    /**
     * 某公司组织架构以二叉搜索树形式记录，节点值为处于该职位的员工编号。请返回第 cnt 大的员工编号。
     */
    private int result = -1;

    private int count = 0;


    public int findTargetNode(TreeNode root, int cnt) {
        helper(root, cnt);

        return result;
    }

    public void helper(TreeNode root, int cnt) {
        if (root == null) {
            return;
        }

        helper(root.right, cnt);

        count++;

        // 反向的后序遍历，用全局变量存储count值
        if (count == cnt) {
            result = root.value;
            return;
        }

        helper(root.left, cnt);
    }
}
