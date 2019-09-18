package Array;

import java.util.Arrays;

public class rotate_array {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
//        int[] res = new int[len];
//        for (int i = 0; i < nums.length; i++) {
//            res[(i + k) % len] = nums[i];
//        }
//
//        for (int j = 0; j < nums.length; j++) {
//            nums[j] = res[j];
//        }
        if (k > len) k = k % len;
        reverse(nums, 0, len - k - 1);
        reverse(nums, len - k, len - 1);
        reverse(nums, 0, len - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        rotate_array ra = new rotate_array();
        int[] test = new int[]{1, 2, 3, 4, 5, 6, 7};
        ra.rotate(test, 2);
        System.out.println(Arrays.toString(test));
    }
}
