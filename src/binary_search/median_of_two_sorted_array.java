import java.util.Arrays;

/**
 * 这是个超级超级经典的分治算法！！这个问题大致是说，如何在给定的两个有序数组里面找其中的中值，或者变形问题，
 * 如何在2个有序数组数组中查找Top K的值（Top K的问题可以转换成求第k个元素的问题）。
 * 这个算法在很多实际应用中都会用到，特别是在当前大数据的背景下。
 */

public class median_of_two_sorted_array {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result = 0.0;
        if (nums1.length == 0) {
            int median = nums2.length / 2;
            if (nums2.length % 2 == 0) {
                result = (nums2[median] + nums2[median - 1]) / 2.0;
            }else {
                result = nums2[median];
            }
        }else if (nums2.length == 0) {
            int median = nums1.length / 2;
            if (nums1.length % 2 == 0) {
                result =  (nums1[median] + nums1[median - 1]) / 2.0;
            }else {
                result = nums1[median];
            }
        }else {
            int m = nums1.length;
            int n = nums2.length;
            int[] arr = new int[m + n];
            int i = 0;
            int j = 0;
            while (i < m) {
                arr[i] = nums1[i];
                i += 1;
            }
            while (j < n) {
                arr[i] = nums2[j];
                i += 1;
                j += 1;
            }
            Arrays.sort(arr);
            int median = (m + n) / 2;
            if ((m + n) % 2 == 0) {
                result = (arr[median] + arr[median - 1]) / 2.0;
            } else {
                result = arr[median];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{2, -4, 7};
        int[] arr2 = new int[]{1, 3, 5, 9};
        median_of_two_sorted_array mt = new median_of_two_sorted_array();
        System.out.println(mt.findMedianSortedArrays(arr1, arr2));
    }
}

// 
