package num;

public class 缺失的第一个正数 {
    /**
     * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
     *
     * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
     */

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 0};
        firstMissingPositive(nums);
    }

    public static int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            System.out.println("i: " + i + " nums[i] - 1: " + (nums[i] - 1) + " num[i]: " + nums[i] + " nums[nums[i] - 1]: " + (nums[nums[i]] - 1));
            while (nums[i] > 0 && nums[i] <= len && nums[i] != nums[nums[i] - 1]) {
                swap(nums, nums[i] - 1, i);
            }
        }

        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return len + 1;

    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
