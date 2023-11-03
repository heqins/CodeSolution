package array;

public class 有序数组的平方_1 {

    /**
     * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
     */
    public int[] sortedSquares(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];

        int left = 0;
        int right = len - 1;
        int index = right;

        while (left <= right) {
            // 双指针，每次最大的元素要么是右边正数的最大的那个，要么是负数最小的那个
            if (nums[left] * nums[left] >= nums[right] * nums[right]) {
                result[index] = nums[left] * nums[left];
                index--;
                left++;
            }else {
                result[index] = nums[right] * nums[right];
                index--;
                right--;
            }
        }

        return result;
    }
}
