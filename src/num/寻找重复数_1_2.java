package num;

public class 寻找重复数_1_2 {

    /**
     * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
     * 假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。
     * 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
     */

    /**
     * 我们知道二分查找要求有序，但是给定的数组不是有序的，那么怎么用二分查找呢？
     * 原数组不是有序，但是我们知道重复的那个数字肯定是 1 到 n 中的某一个，而 1,2...,n 就是一个有序序列。
     * 因此我们可以对 1,2...,n 进行二分查找。
     * mid = (1 + n) / 2，接下来判断最终答案是在 [1, mid] 中还是在 [mid + 1, n] 中。
     * 我们只需要统计原数组中小于等于 mid 的个数，记为 count。
     * 如果 count > mid ，鸽巢原理，在 [1,mid] 范围内的数字个数超过了 mid ，所以一定有一个重复数字。
     * 否则的话，既然不在 [1,mid] ，那么最终答案一定在 [mid + 1, n] 中。
     */
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int mid = 0;

        while (left < right) {
            mid = (right + left) / 2;

            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) {
                    count++;
                }
            }

            if (count > mid) {
                right = mid;
            }else {
                left = mid + 1;
            }
        }

        return left;
    }
}
