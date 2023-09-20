package array;

public class 数组中的第K个最大元素 {

    /**
     * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
     *
     * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
     *
     * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
     */
    public int findKthLargest(int[] nums, int k) {
        // 计数排序
        int[] arr = new int[20001];
        for (int val: nums) {
            arr[val + 10000]++;
        }

        int count = 0;
        // 从右向左
        for (int i = arr.length - 1; i >= 0; i--) {
            count += arr[i];
            if (count >= k) {
                return i - 10000;
            }
        }

        return -1;
    }
}
