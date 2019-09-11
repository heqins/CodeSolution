package Array;

public class find_peak_element {
    public int findPeakElement(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < nums[mid + 1]) {left = mid + 1;}
            else {
                right = mid;
            }
        }

        return left;
    }
}
