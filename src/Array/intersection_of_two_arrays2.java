package Array;

import java.util.Arrays;

public class intersection_of_two_arrays2 {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length == 0) {
            return nums2;
        }
        if (nums2.length == 0) {
            return nums1;
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0, k = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            }else if (nums1[i] > nums2[j]) {
                j++;
            }else if (nums1[i] == nums2[j]) {
                nums1[k++] = nums1[i];
                i++;
                j++;
            }
        }

        return Arrays.copyOfRange(nums1, 0, k);
    }

    public static void main(String[] args) {
        int[] n1 = new int[]{1, 2, 3, 4, 1};
        int[] n2 = new int[]{3, 4};
        intersection_of_two_arrays2 iota2 = new intersection_of_two_arrays2();
        System.out.println(Arrays.toString(iota2.intersect(n1, n2)));
    }
}
