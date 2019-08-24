package Array;

public class minimum_size_subarray {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) return 0;
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        int start = 0;
        for (int end = 0; end < nums.length; end++) {
            sum += nums[end];
            while (sum >= s) {
                minLen = Math.min(minLen, end - start + 1);
                sum -= nums[start++];
            }
        }
        return minLen != Integer.MAX_VALUE ? minLen : 0;
    }

    public static void main(String[] args) {
        int[] test = new int[]{1, 4, 3, 5, 6};
        int s = 5;
        minimum_size_subarray ms = new minimum_size_subarray();
        System.out.println(ms.minSubArrayLen(s, test));
    }
}
