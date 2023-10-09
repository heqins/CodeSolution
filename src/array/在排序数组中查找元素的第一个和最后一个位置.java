package array;

public class 在排序数组中查找元素的第一个和最后一个位置 {
    /**
     * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
     *
     * 如果数组中不存在目标值 target，返回 [-1, -1]。
     *
     * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
     *
     */
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        int start = -1;
        int end = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                start = mid;
                end = mid;

                // while循环可以进行优化，仍然使用二分法来查找区间
                while (start > 0 && nums[start - 1] == target) {
                    start--;
                }

                while (end < nums.length - 1 && nums[end + 1] == target) {
                    end++;
                }

                break;
            }else if (nums[mid] > target){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }

        return new int[]{start, end};
    }

    public int[] searchRange2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        int start = -1;
        int end = -1;

        // 二分查找找到目标值
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                start = mid;
                end = mid;
                break;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        // 如果找到了目标值，继续查找起始位置和结束位置
        if (start != -1) {
            // 二分查找起始位置
            while (left <= start) {
                int mid = left + (start - left) / 2;
                if (nums[mid] == target) {
                    start = mid;
                } else {
                    left = mid + 1;
                }
            }

            // 二分查找结束位置
            while (end <= right) {
                int mid = end + (right - end) / 2;
                if (nums[mid] == target) {
                    end = mid;
                } else {
                    right = mid - 1;
                }
            }
        }

        return new int[]{start, end};
    }

}
