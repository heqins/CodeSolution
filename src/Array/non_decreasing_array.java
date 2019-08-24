package Array;

public class non_decreasing_array {
    public boolean checkPossibility(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return false;
        } else if (nums.length < 2) {
            return true;
        }

        int count = 0;
        for (int i = 0; i < nums.length - 1; i ++) {
            if (nums[i] > nums[i+1]) {
                if (i >= 1 && nums[i-1] < nums[i+1]) {
                    nums[i] = nums[i+1];
                }else if (i >= 1 && nums[i - 1] > nums[i + 1]) {
                    nums[i + 1] = nums[i];
                }
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] test = new int[]{1, 4, 2, 3};
        non_decreasing_array nda = new non_decreasing_array();
        System.out.println(nda.checkPossibility(test));
    }
}
