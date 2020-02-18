public class convert_sorted_array_to_bt {
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode res = helper(nums, 0, nums.length-1);
        return res;
    }
    public TreeNode helper(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        // 二叉搜索树根节点从中间开始
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, start, mid-1);
        root.right = helper(nums, mid+1, end);
        return root;
    }
}
