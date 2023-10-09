package array;

public class 山脉数组中查找目标值 {

    /**
     * 给你一个 山脉数组 mountainArr，请你返回能够使得 mountainArr.get(index) 等于 target 最小 的下标 index 值。
     * 如果不存在这样的下标 index，就请返回 -1。
     * 何为山脉数组？如果数组 A 是一个山脉数组的话，那它满足如下条件：
     * 首先，A.length >= 3
     * 其次，在 0 < i < A.length - 1 条件下，存在 i 使得：
     *
     * A[0] < A[1] < ... A[i-1] < A[i]
     * A[i] > A[i+1] > ... > A[A.length - 1]
     *
     *
     * 你将 不能直接访问该山脉数组，必须通过 MountainArray 接口来获取数据：
     * MountainArray.get(k) - 会返回数组中索引为k 的元素（下标从 0 开始）
     * MountainArray.length() - 会返回该数组的长度
     */

    // 分为三步：1、找到山脉的峰值 2、尝试去峰值左边的有序数组中查找是否有目标值
    // 3、如果左边没有则从右边的有序数组中寻找是否有目标值，注意山脉右边是单调递减的
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int len = mountainArr.length();
        int peakIndex = findPeakIndex(mountainArr, 0, len - 1);
        int res = findSortedArray(mountainArr, 0, peakIndex, target);

        if (res != -1) {
            return res;
        }

        return findReversedSortedArray(mountainArr, peakIndex + 1, len - 1, target);
    }

    public int findPeakIndex(MountainArray mountainArr, int left, int right) {
        // 在这个算法中，使用 left < right 作为循环条件是为了确保搜索的范围是有效的。当 left == right 时，表示搜索范围中只有一个元素，
        // 此时如果不满足搜索条件，就可以终止搜索，因为再继续搜索也不会找到目标值。
        //
        //如果使用 left <= right 作为循环条件，那么当 left 和 right 相等时，仍然会进入循环体内执行一次，
        // 这可能会导致不必要的比较和判断。而且，如果在这种情况下继续执行比较操作，可能会导致数组越界或其他问题。
        //
        //因此，通常情况下，使用 left < right 作为循环条件更为安全和有效，因为它可以确保搜索范围不会收缩到只有一个元素时继续执行循环。
        // 一旦 left 和 right 相等，就表示搜索范围已经缩小到最小，可以终止循环。这种方式可以更好地避免潜在的边界问题和不必要的循环迭代。
        while (left < right) {
            int mid = left + (right - left) / 2;

            // 如果 nums[mid] < nums[mid+1]，则说明峰值在右侧，因此更新 left 为 mid + 1。
            //如果 nums[mid] >= nums[mid+1]，则说明峰值在左侧或者就是 nums[mid] 本身，因此更新 right 为 mid。
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                left = mid + 1;
            }else {
                right = mid;
            }
        }

        return left;
    }

    public int findSortedArray(MountainArray mountainArr, int left, int right, int target) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) == target) {
                return mid;
            }

            if (mountainArr.get(mid) < target) {
                left = mid + 1;
            }else {
                right = mid;
            }
        }

        return mountainArr.get(left) == target ? left : -1;
    }

    public int findReversedSortedArray(MountainArray mountainArr, int left, int right, int target) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) == target) {
                return mid;
            }

            if (mountainArr.get(mid) > target) {
                left = mid + 1;
            }else {
                right = mid;
            }
        }

        return mountainArr.get(left) == target ? left : -1;
    }
}
