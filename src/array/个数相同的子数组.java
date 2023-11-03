package array;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class 个数相同的子数组 {

    /**
     * 题目：输入一个只包含0和1的数组，请问如何求0和1的个数相同的最长连续子数组的长度？
     * 例如，在数组[0，1，0]中有两个子数组包含相同个数的0和1，分别是[0，1]和[1，0]，它们的长度都是2，因此输出2。
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{0,1 ,0};
        int i = find(nums);
        System.out.println(i);
    }

    /**
     * 首先把输入数组中所有的0都替换成-1，那么题目就变成求包含相同数目的-1和1的最长子数组的长度。
     * 在一个只包含数字1和-1的数组中，如果子数组中-1和1的数目相同，那么子数组的所有数字之和就是0，
     * 因此这个题目就变成求数字之和为0的最长子数组的长度
     * 如果数组中前i个数字之和为m，前j个数字（j>i）之和也为m，
     * 那么从第i+1个数字到第j个数字的子数组的数字之和为0，这个和为0的子数组的长度是j-i
     * @param nums
     * @return
     */
    public static int find(int[] nums) {
        Map<Integer, Integer> sumMap = new HashMap<>();
        int sum = 0;
        int count = 0;
        sumMap.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 0 ? -1 : 1;
            if (sumMap.containsKey(sum)) {
                count = Math.max(count, i - sumMap.get(sum));
            }else {
                sumMap.put(sum, i);
            }
        }

        return count;
    }
}
