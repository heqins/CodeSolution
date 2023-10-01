package num;

public class 最大连续1的个数 {

    /**
     * 给定一个二进制数组 nums ， 计算其中最大连续 1 的个数。
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            }else {
                count = 0;
            }

            result = Math.max(result, count);
        }

        return result;
    }
}
