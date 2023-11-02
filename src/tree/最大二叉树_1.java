package tree;

public class 最大二叉树_1 {

    /**
     * 给定一个不重复的整数数组 nums 。 最大二叉树 可以用下面的算法从 nums 递归地构建:
     * 创建一个根节点，其值为 nums 中的最大值。
     * 递归地在最大值 左边 的 子数组前缀上 构建左子树。
     * 递归地在最大值 右边 的 子数组后缀上 构建右子树。
     * 返回 nums 构建的 最大二叉树 。
     */

    // 递归分治
    // 设置递归函数 TreeNode build(int[] nums, int l, int r) 含义为从 nums 中的 [l,r][l, r][l,r] 下标范围进行构建，返回构建后的头结点。
    // 当 l>rl > rl>r 时，返回空节点，否则在 [l,r][l, r][l,r] 中进行扫描，找到最大值对应的下标 idx 并创建对应的头结点，
    // 递归构建 [l,idx−1][l, idx - 1][l,idx−1] 和 [idx+1,r][idx + 1, r][idx+1,r] 作为头节点的左右子树。
    // 时间复杂度：O(n2)  空间复杂度：忽略递归带来的额外空间开销，复杂度为 O(1)

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper(int[] nums, int start, int right) {
        int index = find(nums, start, right);
        if (index == -1) {
            return null;
        }

        TreeNode root = new TreeNode(nums[index]);

        root.left = helper(nums, start, index - 1);
        root.right = helper(nums, index + 1, right);

        return root;
    }

    public int find(int[] nums, int start, int right) {
        if (start > right) {
            return -1;
        }

        int max = Integer.MIN_VALUE;
        int index = -1;

        for (int i = start; i <= right; i++) {
            if (nums[i] > max) {
                index = i;
                max = nums[i];
            }
        }

        return index;
    }
}
