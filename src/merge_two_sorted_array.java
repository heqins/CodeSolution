/**
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

    The number of elements initialized in nums1 and nums2 are m and n respectively.
    You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.

Example:

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]

**/

// 从后向前比较 
public class merge_two_sorted_array {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        while (m > 0 && n > 0) {
            if (nums1[m-1] < nums2[n-1]) {
                nums1[m+n-1] = nums2[n-1];
                n = n - 1;
            }else {
                int temp = nums1[m+n-1];
                nums1[m+n-1]= nums1[m-1];
                nums1[m-1] = temp;
                m = m - 1;
            }
        }
        if (m == 0 && n > 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 3, 5, 6, 0, 0, 0};
        int m = 4;
        int[] nums2 = new int[]{2, 4, 5};
        int n = 3;
        merge_two_sorted_array mt = new merge_two_sorted_array();
        mt.merge(nums1, m, nums2, n);
        System.out.println(nums1[m+n-2]);
    }
}
