package array;

public class 轮转数组 {

    /**
     *给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
     *
     *
     *
     * 示例 1:
     *
     * 输入: nums = [1,2,3,4,5,6,7], k = 3
     * 输出: [5,6,7,1,2,3,4]
     * 解释:
     * 向右轮转 1 步: [7,1,2,3,4,5,6]
     * 向右轮转 2 步: [6,7,1,2,3,4,5]
     * 向右轮转 3 步: [5,6,7,1,2,3,4]
     * 示例 2:
     *
     * 输入：nums = [-1,-100,3,99], k = 2
     * 输出：[3,99,-1,-100]
     * 解释:
     * 向右轮转 1 步: [99,-1,-100,3]
     * 向右轮转 2 步: [3,99,-1,-100]
     */
    public void rotate(int[] nums, int k) {
        k %= nums.length;

        revesre(nums, 0, nums.length - k - 1);
        revesre(nums, nums.length - k, nums.length - 1);
        revesre(nums, 0, nums.length - 1);
    }

    public void revesre(int[] nums, int left, int right) {
        int i = left, j = right;
        while (i < j) {
            if (i < 0 || j > nums.length) {
                break;
            }

            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

            i++;
            j--;
        }
    }
}
