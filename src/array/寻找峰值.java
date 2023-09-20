package array;

public class 寻找峰值 {

    /**
     * 峰值元素是指其值严格大于左右相邻值的元素。
     *
     * 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
     *
     * 你可以假设 nums[-1] = nums[n] = -∞ 。
     *
     * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
     */
    public int findPeakElement(int[] nums) {
        int n = nums.length;

        int left = 0;
        int right = n;

        while (left < right) {
            int mid = (left + right) / 2;

            // 因为只需要找到任意一个峰值，所以每次可以抛弃一半区间
            // 因为两边是负无穷，所以如果右边比当前大，说明右边一定有一个峰值
            if (mid < n - 1 && nums[mid] < nums[mid + 1]) {
                left = mid + 1;
                // 同样的，如果左边比当前大，说明左边一定有一个峰值
            }else if (mid > 0 && nums[mid] < nums[mid - 1]) {
                right = mid - 1;
            }else {
                return mid;
            }
        }

        return left;
    }
}
