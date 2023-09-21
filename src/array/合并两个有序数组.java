package array;

public class 合并两个有序数组 {

    /**
     * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
     *
     * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
     *
     * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，
     * 其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int start1 = m - 1;
        int start2 = n - 1;
        // 因为num1后面有多余位置，定义第三个指针，让nums1,nums2里大的那个放过去
        int pointer = m + n - 1;

        while (start1 >= 0 && start2 >= 0) {
            nums1[pointer--] = nums1[start1] < nums2[start2] ? nums2[start2--] : nums1[start1--];
        }

        while (start1 >= 0) {
            nums1[pointer--] = nums1[start1--];
        }

        while (start2 >= 0) {
            nums1[pointer--] = nums2[start2--];
        }
    }
}
