/**
 * public int search(int[] nums, int target) {
 *         if(nums.length==0) return -1;
 *         int index=0;
 *         for(int i=0;i<nums.length-1;i++){
 *             if(nums[i+1]<nums[i]){
 *                 index=i+1;
 *                 break;
 *             }
 *         }
 *
 *         int res=-1;
 *         if(nums[index]==target){
 *             res=index;
 *         }else{
 *             res=binarySearch(nums,index+1,nums.length-1,target);
 *             if(res==-1){
 *                 res=binarySearch(nums,0,index-1,target);
 *             }
 *         }
 *         return res;
 *     }
 *
 *     private int binarySearch(int[] nums,int left,int right,int target){
 *         while(left <= right){
 *             int middle=left+(right-left)/2;
 *             if(nums[middle]==target) return middle;
 *             else if(nums[middle]>target) right=middle-1;
 *             else if(nums[middle]<target) left=middle+1;
 *         }
 *         return -1;
 *     }
 * }
 */

public class search_in_rotated_sorted_array {
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }

        if (nums.length == 1) {
            if (nums[0] == target) {
                return 0;
            }else {
                return -1;
            }
        }

        int mid = 0;
        int end = nums.length - 1;
        while (mid < end && (mid + 1) < end) {
            if (nums[mid] > nums[mid+1]) {
                break;
            }else {
                mid += 1;
            }
        }

        int res = -1;
        if (nums[mid] == target) {
            res = mid;
        }else {
            res = helper(nums, 0, mid, target);
            if (res == -1) {
                res = helper(nums, mid + 1, end, target);
            }
        }

        return res;
    }

    public int helper(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }else if (nums[mid] > target) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        search_in_rotated_sorted_array sirsa = new search_in_rotated_sorted_array();
        int[] test = new int[]{1, 3};
        System.out.println(sirsa.search(test, 3));
    }
}
