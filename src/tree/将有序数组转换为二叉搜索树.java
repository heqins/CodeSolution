package tree;

public class 将有序数组转换为二叉搜索树 {

    /**
     * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
     *
     * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
     * @param args
     */
    public static void main(String[] args) {

    }

    public static TreeNode solve(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    // 递归的形式，前序遍历，注意理清边界的值
    public static TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);

        return root;
    }
}
