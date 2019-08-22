package Array;

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
