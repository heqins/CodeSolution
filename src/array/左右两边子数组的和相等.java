package array;

public class 左右两边子数组的和相等 {

    /**
     * 题目：输入一个整数数组，如果一个数字左边的子数组的数字之和等于右边的子数组的数字之和，
     * 那么返回该数字的下标。如果存在多个这样的数字，则返回最左边一个数字的下标。
     * 如果不存在这样的数字，则返回-1。例如，在数组[1，7，3，6，2，9]中，
     * 下标为3的数字（值为6）的左边3个数字1、7、3的和与右边两个数字2和9的和相等，都是11，因此正确的输出值是3。
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{1, 7, 3, 6, 2, 9};
        int i = find(nums);
        System.out.println(i);
    }

    /**
     * 当扫描到第i个数字时，它左边的子数组的数字之和就是从第1个数字开始累加到第i-1个数字的和。
     * 此时它右边的子数组的数字之和就是从第i+1个数字开始累加到最后一个数字的和，
     * 这个和等于数组中所有数字之和减去从第1个数字累加到第i个数字的和
     * @param nums
     * @return
     */
    public static int find(int[] nums) {
        int total = 0;
        int sum = 0;
        for (int num: nums) {
            total += num;
        }

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum - nums[i] == total - sum) {
                return i;
            }
        }

        return -1;
    }
}
