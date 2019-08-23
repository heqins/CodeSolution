package BinaryTree;

public class convert_sorted_array_toBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode res = helper(nums, 0, nums.length-1);
        return res;
    }
    public TreeNode helper(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, start, mid-1);
        root.right = helper(nums, mid+1, end);
        return root;
    }
}
