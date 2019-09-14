package Array;

public class search_insert_position {
    public int searchInsert(int[] nums, int target) {
        return helper(nums, target, 0, nums.length - 1);
    }

    public int helper(int[] nums, int target, int left, int right) {
        if (left > right) {
            return left;
        }else {
            int mid = (left + right) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
            return helper(nums, target, left, right);
        }
    }

    public static void main(String[] args) {
        int[] test = new int[]{1,3,5,6};
        int target = 2;
        search_insert_position sip = new search_insert_position();
        System.out.println(sip.searchInsert(test, target));
    }
}
